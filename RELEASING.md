RELEASING
=========

These instructions serve as a reminder on how to release to Maven Central.

Process
-------

1. Increment the version number appropriately. Use [Semantic Versioning](http://semver.org/).

    VERSION=1.1
    mvn versions:set -DnewVersion=$VERSION

2. Verify the release to make sure all is well.

    mvn clean verify -P release

3. Commit and tag the latest release.

    git commit -am "Release $VERSION"
    git tag -a v$VERSION -m "Release $VERSION"

4. Deploy to Sonatype:

    mvn clean deploy -P release

5. Push commit and tag to GitHub

    git push origin master
    git push origin v$VERSION

6. Create a new Releases on GitHub. Use the tag you just created and optionally
   include a change log. Attach the compiled, sources, and javadoc jar files,
   along with the .asc signature files.

7. Prepare the master branch for the next release by incrementing the version number.

    VERSION=1.2-SNAPSHOT
    mvn versions:set -DnewVersion=$VERSION
    git commit -am "Incrementing the version to $VERSION"
    git push origin master
