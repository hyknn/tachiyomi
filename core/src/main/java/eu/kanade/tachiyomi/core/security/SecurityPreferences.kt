package eu.kanade.tachiyomi.core.security

import eu.kanade.tachiyomi.core.R
import eu.kanade.tachiyomi.core.preference.PreferenceStore
import eu.kanade.tachiyomi.core.preference.getEnum

class SecurityPreferences(
    private val preferenceStore: PreferenceStore
) {

    fun useAuthenticator() = this.preferenceStore.getBoolean("use_biometric_lock", false)

    fun lockAppAfter() = this.preferenceStore.getInt("lock_app_after", 0)

    fun secureScreen() = this.preferenceStore.getEnum("secure_screen_v2", SecureScreenMode.INCOGNITO)

    fun hideNotificationContent() = this.preferenceStore.getBoolean("hide_notification_content", false)

    /**
     * For app lock. Will be set when there is a pending timed lock.
     * Otherwise this pref should be deleted.
     */
    fun lastAppClosed() = this.preferenceStore.getLong("last_app_closed", 0)

    enum class SecureScreenMode(val titleResId: Int) {
        ALWAYS(R.string.lock_always),
        INCOGNITO(R.string.pref_incognito_mode),
        NEVER(R.string.lock_never),
    }

}
