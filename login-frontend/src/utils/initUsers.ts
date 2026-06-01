export const initializeUsers = () => {
  const users = localStorage.getItem("users");

  if (!users) {
    const defaultUsers = [
      {
        email: "ananya.parabat@ipca.com",
        password: "ananya123"
      },
      {
        email: "ruchita.saroj@ipca.com",
        password: "ruchita123"
      }
    ];

    localStorage.setItem(
      "users",
      JSON.stringify(defaultUsers)
    );
  }
};