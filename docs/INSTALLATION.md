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

Another way to install Clojure on Windows is with the [Scoop](https://scoop.sh/) package manager. To install scoop, open PowerShell and run these 2 commands, one after the other:

 ```sh
 iwr -useb get.scoop.sh | iex
Set-ExecutionPolicy RemoteSigned -Scope CurrentUser -Force
``

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