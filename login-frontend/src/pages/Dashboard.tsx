import { useNavigate } from "react-router-dom";

function Dashboard() {

  const navigate =
    useNavigate();

  const user = JSON.parse(
    localStorage.getItem(
      "loggedInUser"
    ) || "{}"
  );

  const logout = () => {

    localStorage.removeItem(
      "loggedInUser"
    );

    navigate("/");
  };

  return (
    <div>

      <h1>Dashboard</h1>

      <p>
        Welcome {user.email}
      </p>

      <button onClick={logout}>
        Logout
      </button>

    </div>
  );
}

export default Dashboard;