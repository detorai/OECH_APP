package com.example.oech_app.data.network

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest



object SupabaseClient {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://ukrbfeznexdpgsjlikdd.supabase.co",
        supabaseKey =  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVrcmJmZXpuZXhkcGdzamxpa2RkIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQ4ODM4MjYsImV4cCI6MjA1MDQ1OTgyNn0.W9rXAmDk5rw4OpxLDEpF30DLwPJNpm2xH_gSdJRxUGU"
    ) {
        install(Postgrest)
    }
}