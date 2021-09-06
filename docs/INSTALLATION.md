# Installation

## Installing the Clojure CLI
Clojure provides command line tools that can be used to start a Clojure repl, use Clojure and Java libraries, and start Clojure programs.

### Linux
Ensure that the following dependencies are installed: `bash`, `curl`, `rlwrap`, and `Java`.

```bash
curl -O https://download.clojure.org/install/linux-install-1.10.3.967.sh
chmod +x linux-install-1.10.3.967.sh
sudo ./linux-install-1.10.3.967.sh
```

### Homebrew for Mac OS X
Install the command line tools with brew from the [clojure/tools](https://github.com/clojure/homebrew-tools) tap:

```bash
brew install clojure/tools/clojure
```

### Windows
For running Clojure on Windows it is recommended to use WSL2.