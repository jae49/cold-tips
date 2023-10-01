# Gradle Build Systems Tips

## [Gradle build that is dependent on another gradle build](multi-gradle-project-referencing/README.md)
This shows how to get a gradle build to include another gradle build as a dependency.  Though this example
only shows a single dependency, the technique would extend to allowing one gradle build to include multiple
additional gradle build dependencies.

## [Using centralized dependency versioning for gradle projects](libs-versions-toml/README.md)
Having multiple gradle projects with the same dependencies can often result in mismatched versions
in a final build when one project depends on other projects.  Additionally, when moving to new
versions of dependencies, it can be time-consuming and error-prone to update multiple projects
refering to those dependencies.  One technique that can help is having a single file that stores
desired dependencies and then allow gradle projects to reference that single file.

A recently developed gradle capability called **libs.versions.toml** makes this technique easy to implement.
