# ⌨️ DOSBox Keyboard-Shortcuts

Hier sind die wichtigsten Tastenkombinationen für die Steuerung von DOSBox.

## 🔄 Steuerung & Geschwindigkeit

| Shortcut            | Funktion                                         |
|---------------------|--------------------------------------------------|
| `Ctrl` + `F1`       | Keymapper öffnen (Tastenbelegung ändern)        |
| `Ctrl` + `F5`       | Screenshot erstellen                             |
| `Ctrl` + `F6`       | Audioaufnahme starten/stoppen                    |
| `Ctrl` + `F7`       | Frameskip verringern                             |
| `Ctrl` + `F8`       | Frameskip erhöhen                                |
| `Ctrl` + `F9`       | Sofortiger DOSBox-Abbruch (Shutdown)             |
| `Ctrl` + `F10`      | Mauszeiger fangen/freigeben                      |
| `Ctrl` + `F11`      | CPU-Geschwindigkeit verringern (weniger Cycles)  |
| `Ctrl` + `F12`      | CPU-Geschwindigkeit erhöhen (mehr Cycles)        |

---

## 🧰 Sonstiges

| Shortcut            | Funktion                                         |
|---------------------|--------------------------------------------------|
| `Alt` + `Enter`     | Vollbildmodus ein-/ausschalten                   |
| `Ctrl` + `Pause`    | Emulation anhalten (Pause-Modus)                |
| `Ctrl` + `F4`       | Diskettenwechsel (bei mehreren `.img`-Files)     |

---

## 📝 Hinweise

- Änderungen an der Geschwindigkeit (Cycles) sind wichtig für alte Spiele:
  - **Zu langsam?** → `Ctrl` + `F12` mehrmals drücken
  - **Zu schnell/läuft instabil?** → `Ctrl` + `F11` zum Verlangsamen
- `Ctrl` + `F9` ist ein **Hard Quit** – keine Nachfrage! Sei vorsichtig.
- Die Screenshots landen im `capture`-Ordner im DOSBox-Verzeichnis.

---

## 📁 Bonus: Verzeichnisse mounten

Beim Start einer Sitzung musst du ggf. dein Spieleverzeichnis mounten:

```dos
mount c ~/dosgames
c:

