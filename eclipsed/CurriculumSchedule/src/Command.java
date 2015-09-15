public class Command {

	int cmd = -1;
	Course course;

	public Command(String input) {
		String command;

		String[] split = input.split(" ");
		command = split[0];

		String[] cmds = { "Add", "Remove", "Update", "Find", "Show" };
		for (int i = 0; i < cmds.length; i++) {
			if (command.equals(cmds[i]) == true) {
				cmd = i;
				break;
			}
		}
		// 这里改了(split[0])
		System.out.println("Command" + "  " + split[0]);
		if (0 <= cmd && cmd <= 2) {
			System.out.println(split[1]);
			course = new Course(split[1]);
		} else if (cmd == 3)
			course = new Course(split[1] + "；null；null");
	}

	public int getCmd() {
		return cmd;
	}

	public Course getCourse() {
		return course;
	}

}