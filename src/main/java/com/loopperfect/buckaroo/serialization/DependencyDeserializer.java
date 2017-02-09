package com.loopperfect.buckaroo.serialization;

import com.google.common.base.Preconditions;
import com.google.gson.*;
import com.loopperfect.buckaroo.Dependency;
import com.loopperfect.buckaroo.Identifier;
import com.loopperfect.buckaroo.SemanticVersionRequirement;
import com.loopperfect.buckaroo.SemanticVersionRequirements;

import java.lang.reflect.Type;
import java.util.Optional;

public final class DependencyDeserializer implements JsonDeserializer<Dependency> {

    @Override
    public Dependency deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) throws JsonParseException {

        Preconditions.checkNotNull(jsonElement);
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(context);

        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        final Identifier project = context.deserialize(jsonObject.get("project"), Identifier.class);

        final SemanticVersionRequirement versionRequirement =
                context.deserialize(jsonObject.get("version"), SemanticVersionRequirement.class);

        return Dependency.of(project, versionRequirement);
    }
}