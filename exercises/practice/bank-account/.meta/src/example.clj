(ns bank-account)

(defn open-account []
  (atom 0))

(defn close-account [acct]
  (reset! acct nil))

(defn get-balance [acct]
  @acct)

(defn update-balance [account amount]
  (swap! account + amount))