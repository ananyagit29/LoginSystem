import { Navigate } from "react-router-dom";

interface Props {
  children: React.ReactNode;
}

function ProtectedRoute({
  children,
}: Props) {

  const user =
    localStorage.getItem(
      "loggedInUser"
    );

  return user
    ? children
    : <Navigate to="/" />;
}

export default ProtectedRoute;