
    override fun preprocess(inputStream: InputStream, fileName: String): InputStream {
        if (!fileName.endsWith(".zip", ignoreCase = true)) return inputStream

        val zipPath = materializeZip(inputStream)
        val cityByOrtNumber = try {
            ZipFile(zipPath.toFile()).use { zip ->
                val cityByOrtNumber = loadCityByOrtNumber(zip)
                requireEntry(zip, "gebaeude.txt")
                cityByOrtNumber
            }
        } catch (e: Exception) {
            runCatching { Files.deleteIfExists(zipPath) }
            throw e
        }

        val pipedOut = PipedOutputStream()
        val pipedIn = PipedInputStream(pipedOut)

        Thread {
            try {
                ZipFile(zipPath.toFile()).use { zip ->
                    streamEnrichedGebaeude(zip, cityByOrtNumber, pipedOut)
                }
            } finally {
                runCatching { pipedOut.close() }
                runCatching { Files.deleteIfExists(zipPath) }
            }
        }.start()

        return pipedIn
    }
