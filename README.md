# Kitchen Quest (Android)

BBQ-kitchen arcade game shipped as a WebView app. The game is a single file:
`app/src/main/assets/index.html`.

## Build the APK (GitHub Actions)
1. Push this folder to the `main` branch of `skrude1/kitchen-quest-android`.
2. The "Build Android APK" workflow runs on every push (or trigger it manually).
3. Download the `kitchen-quest-debug-apk` artifact from the run page.

## Build locally (Android Studio)
Open this folder as a project, then Build > Build APK(s).

## Update the game
Replace `app/src/main/assets/index.html` with the newest version and rebuild.
Everything else (career saves, back button, exit bridge) lives in `MainActivity.java`.
