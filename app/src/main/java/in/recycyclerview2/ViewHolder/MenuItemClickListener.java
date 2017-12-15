package in.recycyclerview2.ViewHolder;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import in.recycyclerview2.R;

/**
 * Created by HP on 15-Dec-17.
 */

public class MenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

    Context context;

    public MenuItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_rate:
                Toast.makeText(context, "Rate", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_share:
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();
                return true;
            default:
        }
        return false;
    }
}
