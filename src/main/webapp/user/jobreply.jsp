<div>
	<form action=jobReply.action method="post">
		<pre>	
			<s:textarea label="Reply" name="jrMessage" cols="40" rows="10"/>
			<input type="hidden" name="jobID" value='<s:property value="jobID"/>'>
			<input type="hidden" name="userID" value="${id}"/>
			<button value="REPLY" type="submit">Reply</button>
		</pre>
	</form>	
</div>	
