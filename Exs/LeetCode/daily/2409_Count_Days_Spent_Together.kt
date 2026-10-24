// 24/10/2026
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Solution {
    fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {

        val arriveAliceToList = arriveAlice.split("-")
        val arriveAliceToTime = LocalDate.of(2026, arriveAliceToList[0].toInt(), arriveAliceToList[1].toInt())

        val arriveBobToList = arriveBob.split("-")
        val arriveBobToTime = LocalDate.of(2026, arriveBobToList[0].toInt(), arriveBobToList[1].toInt())

        val leaveAliceToList = leaveAlice.split("-")
        val leaveAliceToTime = LocalDate.of(2026, leaveAliceToList[0].toInt(), leaveAliceToList[1].toInt())

        val leaveBobToList = leaveBob.split("-")
        val leaveBobToTime = LocalDate.of(2026, leaveBobToList[0].toInt(), leaveBobToList[1].toInt())

        val closestArriveTimeToNow =
            if (arriveAliceToTime.isAfter(arriveBobToTime)) arriveAliceToTime else arriveBobToTime

        val closestLeaveTimeToNow =
            if (leaveAliceToTime.isBefore(leaveBobToTime)) leaveAliceToTime else leaveBobToTime

        if (closestArriveTimeToNow.isAfter(closestLeaveTimeToNow)) {
            return 0
        }

        val days = ChronoUnit.DAYS.between(
            closestArriveTimeToNow,
            closestLeaveTimeToNow
        )

        return days.toInt() + 1
    }
}
