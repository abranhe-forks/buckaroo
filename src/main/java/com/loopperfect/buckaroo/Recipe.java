package com.loopperfect.buckaroo;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.net.URI;
import java.net.URL;
import java.util.Objects;

public final class Recipe {

    public final String name;
    public final URI url;
    public final ImmutableMap<SemanticVersion, RecipeVersion> versions;

    private Recipe(final String name, final URI url, final ImmutableMap<SemanticVersion, RecipeVersion> versions) {
        super();
        this.name = Preconditions.checkNotNull(name);
        this.url = Preconditions.checkNotNull(url);
        this.versions = Preconditions.checkNotNull(versions);
    }

    public boolean equals(final Recipe other) {
        Preconditions.checkNotNull(other);
        return this == other ||
            Objects.equals(name, other.name) &&
            Objects.equals(url, other.url) &&
            Objects.equals(versions, other.versions);
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj || obj != null &&
            obj instanceof Recipe &&
            equals((Recipe) obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, versions);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("url", url)
            .add("versions", versions)
            .toString();
    }

    public static Recipe of(
            final String name,
            final URI url,
            final ImmutableMap<SemanticVersion, RecipeVersion> versions) {
        return new Recipe(name, url, versions);
    }
}
