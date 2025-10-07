import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
  id("java")
  id("com.gradleup.shadow") version "9.2.2"
  id("xyz.jpenilla.run-paper") version "2.3.1"
  id("de.eldoria.plugin-yml.paper") version "0.8.0"
}

group = "org.amethystdev"
version = "1.0.0"

repositories {
  mavenCentral()
  maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {

  // Paper
  compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
  paperLibrary("com.google.code.gson", "gson", "2.13.1")

  // Lamp command framework
  var lampVer = "4.0.0-rc.13"
  implementation("io.github.revxrsal:lamp.common:$lampVer")
  implementation("io.github.revxrsal:lamp.bukkit:$lampVer")

  // MiniPlaceholders
  compileOnly("io.github.miniplaceholders:miniplaceholders-api:3.0.1")

}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

tasks {
  compileJava {
    options.release = 21
  }
}

// paper-plugin.yml
paper {
  name = "MyPlugin"
  version = "1.0.0"
  description = "My first plugin"

  main = "org.amethystdev.testplugin.Main"
  prefix = "MyPlugin"
  apiVersion = "1.21"
  authors = listOf("Phrut", "The Amethyst Team")

  // Plugin bootstrapper/loader
  bootstrapper = "org.amethystdev.testplugin.Bootstrapper"
  loader = "org.amethystdev.testplugin.PluginLibrariesLoader"
  hasOpenClassloader = false
  generateLibrariesJson = true

  // TODO: Add Folia support
  //foliaSupported = true

  serverDependencies {
    register("LuckPerms") {
      load = PaperPluginDescription.RelativeLoadOrder.BEFORE
      required = false
    }

    register("WorldEdit") {
      load = PaperPluginDescription.RelativeLoadOrder.BEFORE
      required = false
    }

    register("Essentials") {
      required = false
      joinClasspath = false
    }

    register("PlaceHolderAPI") {
      load = PaperPluginDescription.RelativeLoadOrder.BEFORE
      required = false
    }
  }
}

tasks.withType<JavaCompile> {
    // Preserve parameter names in the bytecode
    options.compilerArgs.add("-parameters")
}

tasks {
  generatePaperPluginDescription {
    addMavenCentralProxy("google", "https://maven-central.storage-download.googleapis.com/maven2")
  }

  runServer {
    minecraftVersion("1.21.8")
    downloadPlugins {

      // Vault replacement
      hangar("ServiceIO","2.2.0")

      modrinth("miniplaceholders", "7caNTwMh")
    }
  }
}