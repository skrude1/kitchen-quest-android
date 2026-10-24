# Kitchen Quest — Android

Kitchen Quest: BBQ kitchen arcade prototype (dishwasher → cook helper career) wrapped in a WebView.

## Build (GitHub Actions — easiest)

1. Create an empty GitHub repo (no README).
2. On the repo page click **Add file → Upload files**, then drag the *contents* of this folder (including the `.github` folder) into the browser window — subfolders upload automatically.
3. Commit. The Actions workflow (`.github/workflows/build-apk.yml`) builds automatically and publishes the APK as the `kitchen-quest-debug-apk` artifact.
4. Go to the repo's **Actions** tab → latest run → download **kitchen-quest-debug-apk** → unzip → `app-debug.apk`.

## Install on your phone

1. Copy `app-debug.apk` to your phone and open it.
2. Allow "Install unknown apps" for your browser/file manager when prompted.
3. Landscape game; touch controls are drawn in-canvas below the kitchen area. Back button quits a shift / exits the app.

## Build locally (alternative)

Open this folder in Android Studio → Build → Build APK(s), or run `gradle assembleDebug` with the Android SDK installed.

## Structure

- `app/src/main/assets/index.html` — the full game (extracted from the Vibe canvas)
- `app/src/main/java/com/quint/kitchenquest/MainActivity.java` — fullscreen WebView wrapper; career progression persists via localStorage
- No external dependencies; minSdk 21; appId `com.quint.kitchenquest`.
