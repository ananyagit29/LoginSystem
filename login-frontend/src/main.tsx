import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { initializeUsers } from "./utils/initUsers";

initializeUsers();

ReactDOM.createRoot(
  document.getElementById("root")!
).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);