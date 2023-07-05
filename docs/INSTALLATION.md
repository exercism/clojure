# Installation

## Installing the Clojure CLI
Clojure provides command line tools that can be used to start a Clojure repl, use Clojure and Java libraries, and start Clojure programs.

If you need to install Java, we recommend [Adoptium Temurin 17](https://adoptium.net/).

### Linux
Ensure that the following dependencies are installed: `bash`, `curl`, `rlwrap`, and `Java`. 
You can install Clojure either of these 2 ways:

1. LinuxBrew - requires [Homebrew](https://brew.sh/)

```bash
brew install clojure/tools/clojure
```

2. Script installer

```bash
curl -O https://download.clojure.org/install/linux-install-1.11.1.1347.sh
chmod +x linux-install-1.11.1.1347.sh
sudo ./linux-install-1.11.1.1347.sh
```

### Homebrew for Mac OS X
Install the command line tools with brew from the [clojure/tools](https://github.com/clojure/homebrew-tools) tap:

```bash
brew install clojure/tools/clojure
```

#### Java

Any distribution of Java will work. If needed, you can install Temurin using brew:

```bash
brew tap homebrew/cask-versions
brew install --cask temurin17
```

### Windows

Clojure on Windows has improved significantly recently. We used to recommended using WSL2, which works great,
but there is now a PowerShell installer. Clojure on Windows is currently in an alpha state, see [clj-on-windows](https://github.com/clojure/tools.deps.alpha/wiki/clj-on-Windows#known-issues) for known issues.

Make sure Java is installed and the `JAVA_HOME` environment variable is set, and run:

```powershell
iwr -useb download.clojure.org/install/win-install-1.11.1.1165.ps1 | iex
```

Another way to install Clojure on Windows is with the [Scoop](https://scoop.sh/) package manager. To install scoop, open PowerShell and run these 2 commands, one after the other:

 ```sh
 iwr -useb get.scoop.sh | iex
Set-ExecutionPolicy RemoteSigned -Scope CurrentUser -Force
```

To install Clojure with Scoop you have to add two important buckets first:

```sh
# if you don't have git version control system installed
# it is required for adding new external buckets to your scoop installer
# you can skip this step otherwise
scoop install git

# add scoop bucket for Java 
scoop bucket add java

# add scoop bucket for clojure build
scoop bucket add scoop-clojure https://github.com/littleli/scoop-clojure
```

Now we are ready to install Java and Clojure by issuing following commands:

```sh
# install Java runtime and compiler
scoop install adoptopenjdk-lts-hotspot

# install official clojure tools
scoop install clojure

# update to the newest version
scoop update clojure
```

After successfully running steps above, you should be able to run Clojure with the following:

```sh
clj
```

## Install Leiningen (optional)

While no longer necessary, we still support the full featured project management tool [Leiningen](https://leiningen.org/).
It offers a wide variety of helpful tasks like convenient testing, builds, and an improved REPL.

1. Download the [lein script](https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein) or [lein.bat](https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein.bat) (Windows)
2. Place it on your `$PATH` where your shell can find it (eg. `/usr/local/bin/`)
3. Set it to be executable (`sudo chmod a+x /usr/local/bin/lein`)
4. Run `lein`.

## Editor integration

The best way to develop Clojure is with an editor-connected REPL. Plugins are available for the most popular editors/IDEs:

- Emacs: [CIDER](https://cider.mx/)
- IntelliJ: [Cursive](https://cursive-ide.com/)
- VSCode: [Calva](https://calva.io/)
- Vim: [Conjure](https://github.com/Olical/conjure)

See the [official docs](https://clojure.org/guides/editors) for more info.
