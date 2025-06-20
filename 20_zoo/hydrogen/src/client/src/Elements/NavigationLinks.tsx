import {Link} from "react-router-dom";

function NavigationLinks() {
  return (
      <div>
              <Link to={"/"}>Home</Link> |{" "}
              <Link to={"/counter"}>Counter</Link> |{" "}
              <Link to={"/fetch"}>Fetch Example</Link> |{" "}
              <Link to={"/form"}>Form Example</Link> |{" "}
              <Link to={"/about"}>About</Link>
      </div>
  );
}

export default NavigationLinks;