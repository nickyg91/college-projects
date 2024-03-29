package calculator.lab6;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void CreateAccountActivity(View v)
    {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void LogIn(View v)
    {
        Database db = new Database(getApplicationContext());
        String userName = ((EditText) findViewById(R.id.UserName)).getText().toString();
        String password = ((EditText) findViewById(R.id.Password)).getText().toString();

        if (userName.equals("") || password.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Bad Username or Password.", Toast.LENGTH_LONG).show();

        }
        else
        {
            //login service
            long userId = db.LogInUser(userName, password);
            if(userId > 0)
            {
                //move to new intent.
                Intent intent = new Intent(this, Calculator.class);
                intent.putExtra("UserId", userId);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Bad Username or Password.", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
