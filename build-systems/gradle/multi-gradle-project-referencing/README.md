# Gradle External Project Referencing
Separating project components into various libraries is a common
project management design pattern that promotes reusability and
API isolation.

The project below has two gradle builds, a **project-tool** build and
a dependency **project-core** build.  There are probably multiple valid
ways to set up the directory structure for such builds, but I've
generally structured the projects at the same level in the hierarchy
under a common root parent and used relative directory references
to allow one build to reference another.

In this example, the **multi-gradle-project-referencing** directory contains
two gradle build directories, **project-core** and **project-tool**.  **project-tool**
is dependent on **project-core** to successfully compile.

A **gradle build** command executed in the **project-core** directory will
also build **project-tool**.

## [project-core (the dependency)](project-core)
In order for **project-tool** to properly reference **project-core**, **project-core**
will have to have it's project name correctly identified in the **settings.gradle.kts** file
and a proper group name and version number in the **build.gradle.kts** file.  Those two settings
will combine in this case to allow another project to reference the dependency with the following line:
   **implementation("net.rednode:project-core:1.0.0")**

### [project-core/settings.gradle.kts](project-core/settings.gradle.kts)
In this part of the gradle build, the **rootProject.name** is set to **project-core**.

### [project-core/build.gradle.kts](project-core/build.gradle.kts)
In this part of the gradle build, the **group** is set to **rednode.net** and **version**
is set to **1.0.0**.

## [project-tool (the build that references the dependency)](project-tool)
The project-tool build requires an include statement in its **setttings.gradle.kts** file
along with a dependency reference in its **build.gradle.kts** file.

### [project-tool/settings.gradle.kts](project-tool/settings.gradle.kts)
In this part of the gradle build, the **includeBuild("../project-core")** is used to allow
this gradle build to reference the gradle build dependency.  Note the use of a relative directory
reference that, in this case, works because both gradle builds are at the same hierarchical level.

### [project-tool/build.gradle.kts](project-tool/build.gradle.kts)
In this part of the gradle build, the inclusion of **implementation("net.rednode:project-core:1.0.0")**
in the dependency section allows the gradle build to properly include the dependency.
