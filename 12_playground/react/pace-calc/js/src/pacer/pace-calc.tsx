import {useState} from "react";

function PaceCalc() {
  const [distance, setDistanceInMeter] = useState(42195)

  return (
      <>
      <h1>The PaceCalcer</h1>
        <div>
          <table>
            <tbody>
            <tr><td>Distance (m):</td><td><input/></td></tr>
            <tr><td>Pace (sec / km):</td><td><input/></td></tr>
            </tbody>
          </table>
        </div>
      </>
  )
}

export default PaceCalc