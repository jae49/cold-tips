package net.rednode.tool

import net.rednode.core.CoreDependency

class ProjectTool {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Project Tool")
            println("Depends on ${CoreDependency().depend()}")
        }
    }

}