package com.jurelmp.reminders;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.sql.SQLException;

public class RemindersActivity extends AppCompatActivity {

    private ListView mListView;
    private RemindersDbAdapter mDbAdapter;
    private RemindersSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        mListView = (ListView) findViewById(R.id.reminders_list_view);
        mListView.setDivider(null);
        mDbAdapter = new RemindersDbAdapter(this);
        try {
            mDbAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cursor cursor = mDbAdapter.fetchAllReminders();

        // from columns defined in the db
        String[] from = new String[]{RemindersDbAdapter.COL_CONTENT};

        // to the ids of views in the layout
        int[] to = new int[]{R.id.row_text};

        mCursorAdapter = new RemindersSimpleCursorAdapter(
                // context
                RemindersActivity.this,
                // the layout of the row
                R.layout.reminders_row,
                // cursor
                cursor,
                // from columns defined in the db
                from,
                // to the ids of views in the layout
                to,
                // flag = not used
                0
        );

        // the cursorAdapter (controller) is now updating the listView (view)
        // with the data from the db (model)
        mListView.setAdapter(mCursorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reminders, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new:
                /**
                 * Create new Reminder
                 */
                Log.d(getLocalClassName(), "create new Reminder");
                return true;
            case R.id.action_exit:
                finish();
                return true;
            default:
                return false;
        }
    }
}
