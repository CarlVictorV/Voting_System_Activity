# VotingSystemActivity


<head>
	<title>Voting System Activity</title>
</head>
<body>
	<h1>High-Level Specifications:</h1>
	<ul>
		<li>The system should have 3 types of users: Superuser, Officer, and Voter.</li>
		<li>The superuser can only add, remove, and update an officer and voter.</li>
		<li>The officer can only add, remove, and update candidates.</li>
		<li>The voter can only vote for candidates.</li>
		<li>The digital ballot should display the candidates for (3) President, (3) Vice President, (10) Senators, (10) District Representatives, (3) Governors, and (3) Mayors.</li>
		<li>The voter can only submit his/her vote if it complies with the voting requirement below:</li>
		<ul>
			<li>1 President, 1 VP, 5 Senators, 4 Representatives, 1 Governor, 1 Mayor</li>
		</ul>
		<li>The voter cannot start voting unless the maximum number of candidates per position is satisfied.</li>
		<li>If at least 1 voter has submitted his/her vote, an officer can no longer modify the roster of candidates.</li>
		<li>A summary, preferably in a graphical form, of the number of votes per candidate should be available to all users.</li>
		<li>However, voters can only view the report after they have submitted their vote.</li>
	</ul>

	<h1>Technical Specifications:</h1>
	<ul>
		<li>Implement the following:</li>
		<ul>
			<li>Encapsulation</li>
			<li>Inheritance</li>
			<li>Polymorphism</li>
			<li>Constructor Overloading</li>
			<li>GUI (required)</li>
		</ul>
		<li>Upload your codes in Javadoc format.</li>
	</ul>
</body>

