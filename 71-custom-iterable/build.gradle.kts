plugins {
    java
}

tasks.register<JavaExec>("RunPlainTest"){
    group = "application" // Lo raggruppa in una cartella comoda
    description = "Runs the TestIterablePlain main method"

    // Dice a Gradle di usare il classpath corretto
    classpath = sourceSets.main.get().runtimeClasspath

    // Specifica quale classe avviare
    mainClass.set("it.unibo.inner.TestIterablePlain")
}

tasks.register<JavaExec>("RunPolicyTest"){
    group = "application" // Lo raggruppa in una cartella comoda
    description = "Runs the TestIterablePlain main method"

    // Dice a Gradle di usare il classpath corretto
    classpath = sourceSets.main.get().runtimeClasspath

    // Specifica quale classe avviare
    mainClass.set("it.unibo.inner.TestIterableWithPolicy")
}