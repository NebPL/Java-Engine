# Java-Engine
Das hier ist eine basic Java engine. Die Engine ist von ein Yt tutorial.


# How to implement

```
repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io") // JitPack für GitHub-Repos
    }
}

dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'

    implementation 'com.github.NebPL:Java-Engine:main-SNAPSHOT' // `main-SNAPSHOT` durch gewünschte Version ersetzen
}
