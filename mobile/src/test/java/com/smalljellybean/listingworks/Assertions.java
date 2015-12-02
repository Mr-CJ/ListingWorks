//package com.smalljellybean.listingworks;
//
//import android.accessibilityservice.AccessibilityServiceInfo;
//import android.accounts.Account;
//import android.animation.Animator;
//import android.animation.AnimatorSet;
//import android.animation.Keyframe;
//import android.animation.ObjectAnimator;
//import android.animation.PropertyValuesHolder;
//import android.animation.ValueAnimator;
//import android.app.ActionBar;
//import android.app.Activity;
//import android.app.Dialog;
//import android.app.DialogFragment;
//import android.app.ExpandableListActivity;
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
//import android.app.Instrumentation;
//import android.app.KeyguardManager;
//import android.app.ListActivity;
//import android.app.ListFragment;
//import android.app.LoaderManager;
//import android.app.LocalActivityManager;
//import android.app.Notification;
//import android.app.PendingIntent;
//import android.app.ProgressDialog;
//import android.app.Service;
//import android.app.TaskStackBuilder;
//import android.app.UiModeManager;
//import android.bluetooth.BluetoothClass;
//import android.bluetooth.BluetoothDevice;
//import android.bluetooth.BluetoothGattCharacteristic;
//import android.bluetooth.BluetoothGattDescriptor;
//import android.bluetooth.BluetoothGattService;
//import android.content.AsyncTaskLoader;
//import android.content.ContentValues;
//import android.content.CursorLoader;
//import android.content.Intent;
//import android.content.Loader;
//import android.content.SharedPreferences;
//import android.content.res.Configuration;
//import android.database.AbstractCursor;
//import android.database.Cursor;
//import android.database.CursorWindow;
//import android.database.sqlite.SQLiteDatabase;
//import android.gesture.Gesture;
//import android.gesture.GestureLibrary;
//import android.gesture.GestureOverlayView;
//import android.gesture.GesturePoint;
//import android.gesture.GestureStore;
//import android.gesture.GestureStroke;
//import android.gesture.OrientedBoundingBox;
//import android.gesture.Prediction;
//import android.graphics.Bitmap;
//import android.graphics.BitmapRegionDecoder;
//import android.graphics.Camera;
//import android.graphics.Canvas;
//import android.graphics.Interpolator;
//import android.graphics.Matrix;
//import android.graphics.Movie;
//import android.graphics.NinePatch;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.graphics.PathMeasure;
//import android.graphics.Picture;
//import android.graphics.Point;
//import android.graphics.PointF;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.graphics.Region;
//import android.graphics.Typeface;
//import android.graphics.YuvImage;
//import android.graphics.drawable.AnimationDrawable;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.graphics.drawable.GradientDrawable;
//import android.graphics.drawable.LayerDrawable;
//import android.graphics.drawable.TransitionDrawable;
//import android.graphics.drawable.shapes.Shape;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.usb.UsbAccessory;
//import android.hardware.usb.UsbDevice;
//import android.hardware.usb.UsbDeviceConnection;
//import android.hardware.usb.UsbEndpoint;
//import android.hardware.usb.UsbInterface;
//import android.hardware.usb.UsbRequest;
//import android.inputmethodservice.ExtractEditText;
//import android.location.Address;
//import android.location.Criteria;
//import android.location.GpsSatellite;
//import android.location.GpsStatus;
//import android.location.Location;
//import android.location.LocationProvider;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.PowerManager;
//import android.os.Vibrator;
//import android.preference.CheckBoxPreference;
//import android.preference.DialogPreference;
//import android.preference.EditTextPreference;
//import android.preference.ListPreference;
//import android.preference.MultiSelectListPreference;
//import android.preference.Preference;
//import android.preference.PreferenceActivity;
//import android.preference.PreferenceGroup;
//import android.preference.PreferenceScreen;
//import android.preference.RingtonePreference;
//import android.preference.SwitchPreference;
//import android.preference.TwoStatePreference;
//import android.telephony.CellIdentityCdma;
//import android.telephony.CellIdentityGsm;
//import android.telephony.CellIdentityLte;
//import android.telephony.CellIdentityWcdma;
//import android.telephony.CellInfo;
//import android.telephony.CellInfoCdma;
//import android.telephony.CellInfoGsm;
//import android.telephony.CellInfoLte;
//import android.telephony.CellInfoWcdma;
//import android.telephony.CellSignalStrengthCdma;
//import android.telephony.CellSignalStrengthGsm;
//import android.telephony.CellSignalStrengthLte;
//import android.telephony.CellSignalStrengthWcdma;
//import android.telephony.NeighboringCellInfo;
//import android.telephony.ServiceState;
//import android.telephony.SignalStrength;
//import android.telephony.SmsMessage;
//import android.telephony.TelephonyManager;
//import android.telephony.cdma.CdmaCellLocation;
//import android.telephony.gsm.GsmCellLocation;
//import android.text.BidiFormatter;
//import android.util.ArrayMap;
//import android.util.AtomicFile;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.util.LongSparseArray;
//import android.util.LruCache;
//import android.util.Pair;
//import android.util.Property;
//import android.util.SparseArray;
//import android.util.SparseBooleanArray;
//import android.util.SparseIntArray;
//import android.util.SparseLongArray;
//import android.view.ActionMode;
//import android.view.ActionProvider;
//import android.view.Display;
//import android.view.DragEvent;
//import android.view.KeyCharacterMap;
//import android.view.KeyEvent;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.OrientationEventListener;
//import android.view.ScaleGestureDetector;
//import android.view.Surface;
//import android.view.TextureView;
//import android.view.VelocityTracker;
//import android.view.View;
//import android.view.ViewConfiguration;
//import android.view.ViewGroup;
//import android.view.ViewPropertyAnimator;
//import android.view.ViewStub;
//import android.view.ViewTreeObserver;
//import android.view.Window;
//import android.view.accessibility.AccessibilityEvent;
//import android.view.accessibility.AccessibilityManager;
//import android.view.accessibility.AccessibilityNodeInfo;
//import android.view.accessibility.AccessibilityRecord;
//import android.view.animation.Animation;
//import android.view.animation.AnimationSet;
//import android.view.animation.GridLayoutAnimationController;
//import android.view.animation.LayoutAnimationController;
//import android.view.animation.Transformation;
//import android.webkit.WebView;
//import android.widget.AbsListView;
//import android.widget.AbsSeekBar;
//import android.widget.AbsSpinner;
//import android.widget.AbsoluteLayout;
//import android.widget.Adapter;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.CalendarView;
//import android.widget.CheckedTextView;
//import android.widget.Chronometer;
//import android.widget.CompoundButton;
//import android.widget.CursorAdapter;
//import android.widget.DatePicker;
//import android.widget.ExpandableListView;
//import android.widget.FrameLayout;
//import android.widget.GridLayout;
//import android.widget.GridView;
//import android.widget.HeaderViewListAdapter;
//import android.widget.HorizontalScrollView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListAdapter;
//import android.widget.ListPopupWindow;
//import android.widget.ListView;
//import android.widget.MediaController;
//import android.widget.NumberPicker;
//import android.widget.PopupWindow;
//import android.widget.ProgressBar;
//import android.widget.RadioGroup;
//import android.widget.RatingBar;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.SearchView;
//import android.widget.SimpleAdapter;
//import android.widget.SimpleCursorAdapter;
//import android.widget.SlidingDrawer;
//import android.widget.Spinner;
//import android.widget.Switch;
//import android.widget.TabHost;
//import android.widget.TabWidget;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//import android.widget.TimePicker;
//import android.widget.Toast;
//import android.widget.ToggleButton;
//import android.widget.VideoView;
//import android.widget.ViewAnimator;
//import android.widget.ViewFlipper;
//import android.widget.ViewSwitcher;
//import android.widget.WrapperListAdapter;
//
//import org.assertj.android.api.accessibilityservice.AccessibilityServiceInfoAssert;
//import org.assertj.android.api.accounts.AccountAssert;
//import org.assertj.android.api.animation.AnimatorAssert;
//import org.assertj.android.api.animation.AnimatorSetAssert;
//import org.assertj.android.api.animation.KeyframeAssert;
//import org.assertj.android.api.animation.ObjectAnimatorAssert;
//import org.assertj.android.api.animation.PropertyValuesHolderAssert;
//import org.assertj.android.api.animation.ValueAnimatorAssert;
//import org.assertj.android.api.app.ActionBarAssert;
//import org.assertj.android.api.app.ActivityAssert;
//import org.assertj.android.api.app.DialogAssert;
//import org.assertj.android.api.app.DialogFragmentAssert;
//import org.assertj.android.api.app.ExpandableListActivityAssert;
//import org.assertj.android.api.app.FragmentAssert;
//import org.assertj.android.api.app.FragmentManagerAssert;
//import org.assertj.android.api.app.FragmentTransactionAssert;
//import org.assertj.android.api.app.InstrumentationActivityMonitorAssert;
//import org.assertj.android.api.app.InstrumentationActivityResultAssert;
//import org.assertj.android.api.app.KeyguardManagerAssert;
//import org.assertj.android.api.app.ListActivityAssert;
//import org.assertj.android.api.app.ListFragmentAssert;
//import org.assertj.android.api.app.LoaderManagerAssert;
//import org.assertj.android.api.app.LocalActivityManagerAssert;
//import org.assertj.android.api.app.NotificationAssert;
//import org.assertj.android.api.app.PendingIntentAssert;
//import org.assertj.android.api.app.ProgressDialogAssert;
//import org.assertj.android.api.app.ServiceAssert;
//import org.assertj.android.api.app.TaskStackBuilderAssert;
//import org.assertj.android.api.app.UiModeManagerAssert;
//import org.assertj.android.api.bluetooth.BluetoothClassAssert;
//import org.assertj.android.api.bluetooth.BluetoothDeviceAssert;
//import org.assertj.android.api.bluetooth.BluetoothGattCharacteristicAssert;
//import org.assertj.android.api.bluetooth.BluetoothGattDescriptorAssert;
//import org.assertj.android.api.bluetooth.BluetoothGattServiceAssert;
//import org.assertj.android.api.content.AsyncTaskLoaderAssert;
//import org.assertj.android.api.content.ContentValuesAssert;
//import org.assertj.android.api.content.CursorLoaderAssert;
//import org.assertj.android.api.content.IntentAssert;
//import org.assertj.android.api.content.LoaderAssert;
//import org.assertj.android.api.content.SharedPreferencesAssert;
//import org.assertj.android.api.content.res.ConfigurationAssert;
//import org.assertj.android.api.database.AbstractCursor_Assert;
//import org.assertj.android.api.database.CursorAssert;
//import org.assertj.android.api.database.CursorWindowAssert;
//import org.assertj.android.api.database.sqlite.SqliteDatabaseAssert;
//import org.assertj.android.api.gesture.GestureAssert;
//import org.assertj.android.api.gesture.GestureLibraryAssert;
//import org.assertj.android.api.gesture.GestureOverlayViewAssert;
//import org.assertj.android.api.gesture.GesturePointAssert;
//import org.assertj.android.api.gesture.GestureStoreAssert;
//import org.assertj.android.api.gesture.GestureStrokeAssert;
//import org.assertj.android.api.gesture.OrientedBoundingBoxAssert;
//import org.assertj.android.api.gesture.PredictionAssert;
//import org.assertj.android.api.graphics.BitmapAssert;
//import org.assertj.android.api.graphics.BitmapRegionDecoderAssert;
//import org.assertj.android.api.graphics.CameraAssert;
//import org.assertj.android.api.graphics.CanvasAssert;
//import org.assertj.android.api.graphics.InterpolatorAssert;
//import org.assertj.android.api.graphics.MatrixAssert;
//import org.assertj.android.api.graphics.MovieAssert;
//import org.assertj.android.api.graphics.NinePatchAssert;
//import org.assertj.android.api.graphics.PaintAssert;
//import org.assertj.android.api.graphics.PathAssert;
//import org.assertj.android.api.graphics.PathMeasureAssert;
//import org.assertj.android.api.graphics.PictureAssert;
//import org.assertj.android.api.graphics.PointAssert;
//import org.assertj.android.api.graphics.PointFAssert;
//import org.assertj.android.api.graphics.RectAssert;
//import org.assertj.android.api.graphics.RectFAssert;
//import org.assertj.android.api.graphics.RegionAssert;
//import org.assertj.android.api.graphics.TypefaceAssert;
//import org.assertj.android.api.graphics.YuvImageAssert;
//import org.assertj.android.api.graphics.drawable.AnimationDrawableAssert;
//import org.assertj.android.api.graphics.drawable.BitmapDrawableAssert;
//import org.assertj.android.api.graphics.drawable.ColorDrawableAssert;
//import org.assertj.android.api.graphics.drawable.DrawableAssert;
//import org.assertj.android.api.graphics.drawable.GradientDrawableAssert;
//import org.assertj.android.api.graphics.drawable.LayerDrawableAssert;
//import org.assertj.android.api.graphics.drawable.TransitionDrawableAssert;
//import org.assertj.android.api.graphics.drawable.shapes.ShapeAssert;
//import org.assertj.android.api.hardware.SensorAssert;
//import org.assertj.android.api.hardware.SensorEventAssert;
//import org.assertj.android.api.hardware.usb.UsbAccessoryAssert;
//import org.assertj.android.api.hardware.usb.UsbDeviceAssert;
//import org.assertj.android.api.hardware.usb.UsbDeviceConnectionAssert;
//import org.assertj.android.api.hardware.usb.UsbEndpointAssert;
//import org.assertj.android.api.hardware.usb.UsbInterfaceAssert;
//import org.assertj.android.api.hardware.usb.UsbRequestAssert;
//import org.assertj.android.api.inputmethodservice.ExtractEditTextAssert;
//import org.assertj.android.api.location.AddressAssert;
//import org.assertj.android.api.location.CriteriaAssert;
//import org.assertj.android.api.location.GpsSatelliteAssert;
//import org.assertj.android.api.location.GpsStatusAssert;
//import org.assertj.android.api.location.LocationAssert;
//import org.assertj.android.api.location.LocationProviderAssert;
//import org.assertj.android.api.os.AsyncTaskAssert;
//import org.assertj.android.api.os.BundleAssert;
//import org.assertj.android.api.os.PowerManagerAssert;
//import org.assertj.android.api.os.VibratorAssert;
//import org.assertj.android.api.preference.CheckBoxPreferenceAssert;
//import org.assertj.android.api.preference.DialogPreferenceAssert;
//import org.assertj.android.api.preference.EditTextPreferenceAssert;
//import org.assertj.android.api.preference.ListPreferenceAssert;
//import org.assertj.android.api.preference.MultiSelectListPreferenceAssert;
//import org.assertj.android.api.preference.PreferenceActivityAssert;
//import org.assertj.android.api.preference.PreferenceAssert;
//import org.assertj.android.api.preference.PreferenceGroupAssert;
//import org.assertj.android.api.preference.PreferenceScreenAssert;
//import org.assertj.android.api.preference.RingtonePreferenceAssert;
//import org.assertj.android.api.preference.SwitchPreferenceAssert;
//import org.assertj.android.api.preference.TwoStatePreferenceAssert;
//import org.assertj.android.api.telephony.CellIdentityCdmaAssert;
//import org.assertj.android.api.telephony.CellIdentityGsmAssert;
//import org.assertj.android.api.telephony.CellIdentityLteAssert;
//import org.assertj.android.api.telephony.CellIdentityWcdmaAssert;
//import org.assertj.android.api.telephony.CellInfoAssert;
//import org.assertj.android.api.telephony.CellInfoCdmaAssert;
//import org.assertj.android.api.telephony.CellInfoGsmAssert;
//import org.assertj.android.api.telephony.CellInfoLteAssert;
//import org.assertj.android.api.telephony.CellInfoWcdmaAssert;
//import org.assertj.android.api.telephony.CellSignalStrengthCdmaAssert;
//import org.assertj.android.api.telephony.CellSignalStrengthGsmAssert;
//import org.assertj.android.api.telephony.CellSignalStrengthLteAssert;
//import org.assertj.android.api.telephony.CellSignalStrengthWcdmaAssert;
//import org.assertj.android.api.telephony.NeighboringCellInfoAssert;
//import org.assertj.android.api.telephony.ServiceStateAssert;
//import org.assertj.android.api.telephony.SignalStrengthAssert;
//import org.assertj.android.api.telephony.SmsMessageAssert;
//import org.assertj.android.api.telephony.TelephonyManagerAssert;
//import org.assertj.android.api.telephony.cdma.CdmaCellLocationAssert;
//import org.assertj.android.api.telephony.gsm.GsmCellLocationAssert;
//import org.assertj.android.api.text.BidiFormatterAssert;
//import org.assertj.android.api.util.ArrayMapAssert;
//import org.assertj.android.api.util.AtomicFileAssert;
//import org.assertj.android.api.util.AttributeSetAssert;
//import org.assertj.android.api.util.DisplayMetricsAssert;
//import org.assertj.android.api.util.LongSparseArrayAssert;
//import org.assertj.android.api.util.LruCacheAssert;
//import org.assertj.android.api.util.PairAssert;
//import org.assertj.android.api.util.PropertyAssert;
//import org.assertj.android.api.util.SparseArrayAssert;
//import org.assertj.android.api.util.SparseBooleanArrayAssert;
//import org.assertj.android.api.util.SparseIntArrayAssert;
//import org.assertj.android.api.util.SparseLongArrayAssert;
//import org.assertj.android.api.view.ActionModeAssert;
//import org.assertj.android.api.view.ActionProviderAssert;
//import org.assertj.android.api.view.DisplayAssert;
//import org.assertj.android.api.view.DragEventAssert;
//import org.assertj.android.api.view.KeyCharacterMapAssert;
//import org.assertj.android.api.view.KeyEventAssert;
//import org.assertj.android.api.view.MenuAssert;
//import org.assertj.android.api.view.MenuItemAssert;
//import org.assertj.android.api.view.OrientationEventListenerAssert;
//import org.assertj.android.api.view.ScaleGestureDetectorAssert;
//import org.assertj.android.api.view.SurfaceAssert;
//import org.assertj.android.api.view.TextureViewAssert;
//import org.assertj.android.api.view.VelocityTrackerAssert;
//import org.assertj.android.api.view.ViewAssert;
//import org.assertj.android.api.view.ViewConfigurationAssert;
//import org.assertj.android.api.view.ViewGroupAssert;
//import org.assertj.android.api.view.ViewGroupLayoutParamsAssert;
//import org.assertj.android.api.view.ViewGroupMarginLayoutParamsAssert;
//import org.assertj.android.api.view.ViewPropertyAnimatorAssert;
//import org.assertj.android.api.view.ViewStubAssert;
//import org.assertj.android.api.view.ViewTreeObserverAssert;
//import org.assertj.android.api.view.WindowAssert;
//import org.assertj.android.api.view.accessibility.AccessibilityEventAssert;
//import org.assertj.android.api.view.accessibility.AccessibilityManagerAssert;
//import org.assertj.android.api.view.accessibility.AccessibilityNodeInfoAssert;
//import org.assertj.android.api.view.accessibility.AccessibilityRecordAssert;
//import org.assertj.android.api.view.animation.AnimationAssert;
//import org.assertj.android.api.view.animation.AnimationSetAssert;
//import org.assertj.android.api.view.animation.GridLayoutAnimationControllerAssert;
//import org.assertj.android.api.view.animation.LayoutAnimationControllerAssert;
//import org.assertj.android.api.view.animation.TransformationAssert;
//import org.assertj.android.api.webkit.WebViewAssert;
//import org.assertj.android.api.widget.AbsListViewAssert;
//import org.assertj.android.api.widget.AbsSeekBarAssert;
//import org.assertj.android.api.widget.AbsSpinnerAssert;
//import org.assertj.android.api.widget.AbsoluteLayoutAssert;
//import org.assertj.android.api.widget.AdapterAssert;
//import org.assertj.android.api.widget.AdapterViewAssert;
//import org.assertj.android.api.widget.ArrayAdapterAssert;
//import org.assertj.android.api.widget.AutoCompleteTextViewAssert;
//import org.assertj.android.api.widget.CalendarViewAssert;
//import org.assertj.android.api.widget.CheckedTextViewAssert;
//import org.assertj.android.api.widget.ChronometerAssert;
//import org.assertj.android.api.widget.CompoundButtonAssert;
//import org.assertj.android.api.widget.CursorAdapterAssert;
//import org.assertj.android.api.widget.DatePickerAssert;
//import org.assertj.android.api.widget.ExpandableListViewAssert;
//import org.assertj.android.api.widget.FrameLayoutAssert;
//import org.assertj.android.api.widget.GridLayoutAssert;
//import org.assertj.android.api.widget.GridViewAssert;
//import org.assertj.android.api.widget.HeaderViewListAdapterAssert;
//import org.assertj.android.api.widget.HorizontalScrollViewAssert;
//import org.assertj.android.api.widget.ImageViewAssert;
//import org.assertj.android.api.widget.LinearLayoutAssert;
//import org.assertj.android.api.widget.ListAdapterAssert;
//import org.assertj.android.api.widget.ListPopupWindowAssert;
//import org.assertj.android.api.widget.ListViewAssert;
//import org.assertj.android.api.widget.MediaControllerAssert;
//import org.assertj.android.api.widget.NumberPickerAssert;
//import org.assertj.android.api.widget.PopupWindowAssert;
//import org.assertj.android.api.widget.ProgressBarAssert;
//import org.assertj.android.api.widget.RadioGroupAssert;
//import org.assertj.android.api.widget.RatingBarAssert;
//import org.assertj.android.api.widget.RelativeLayoutAssert;
//import org.assertj.android.api.widget.ScrollViewAssert;
//import org.assertj.android.api.widget.SearchViewAssert;
//import org.assertj.android.api.widget.SimpleAdapterAssert;
//import org.assertj.android.api.widget.SimpleCursorAdapterAssert;
//import org.assertj.android.api.widget.SlidingDrawerAssert;
//import org.assertj.android.api.widget.SpinnerAssert;
//import org.assertj.android.api.widget.SwitchAssert;
//import org.assertj.android.api.widget.TabHostAssert;
//import org.assertj.android.api.widget.TabWidgetAssert;
//import org.assertj.android.api.widget.TableLayoutAssert;
//import org.assertj.android.api.widget.TableRowAssert;
//import org.assertj.android.api.widget.TextViewAssert;
//import org.assertj.android.api.widget.TimePickerAssert;
//import org.assertj.android.api.widget.ToastAssert;
//import org.assertj.android.api.widget.ToggleButtonAssert;
//import org.assertj.android.api.widget.VideoViewAssert;
//import org.assertj.android.api.widget.ViewAnimatorAssert;
//import org.assertj.android.api.widget.ViewFlipperAssert;
//import org.assertj.android.api.widget.ViewSwitcherAssert;
//import org.assertj.android.api.widget.WrapperListAdapterAssert;
//
//public class Assertions {
//
//    public static AccessibilityServiceInfoAssert androidAssertThat(AccessibilityServiceInfo actual) {
//        return new AccessibilityServiceInfoAssert(actual);
//    }
//
//    public static AccountAssert androidAssertThat(Account actual) {
//        return new AccountAssert(actual);
//    }
//
//    public static AnimatorAssert androidAssertThat(Animator actual) {
//        return new AnimatorAssert(actual);
//    }
//
//    public static AnimatorSetAssert androidAssertThat(AnimatorSet actual) {
//        return new AnimatorSetAssert(actual);
//    }
//
//    public static KeyframeAssert androidAssertThat(Keyframe actual) {
//        return new KeyframeAssert(actual);
//    }
//
//    public static ObjectAnimatorAssert androidAssertThat(ObjectAnimator actual) {
//        return new ObjectAnimatorAssert(actual);
//    }
//
//    public static PropertyValuesHolderAssert androidAssertThat(PropertyValuesHolder actual) {
//        return new PropertyValuesHolderAssert(actual);
//    }
//
//    public static ValueAnimatorAssert androidAssertThat(ValueAnimator actual) {
//        return new ValueAnimatorAssert(actual);
//    }
//
//    public static ActionBarAssert androidAssertThat(ActionBar actual) {
//        return new ActionBarAssert(actual);
//    }
//
//    public static ActivityAssert androidAssertThat(Activity actual) {
//        return new ActivityAssert(actual);
//    }
//
//    public static DialogAssert androidAssertThat(Dialog actual) {
//        return new DialogAssert(actual);
//    }
//
//    public static DialogFragmentAssert androidAssertThat(DialogFragment actual) {
//        return new DialogFragmentAssert(actual);
//    }
//
//    public static ExpandableListActivityAssert androidAssertThat(ExpandableListActivity actual) {
//        return new ExpandableListActivityAssert(actual);
//    }
//
//    public static FragmentAssert androidAssertThat(Fragment actual) {
//        return new FragmentAssert(actual);
//    }
//
//    public static FragmentManagerAssert androidAssertThat(FragmentManager actual) {
//        return new FragmentManagerAssert(actual);
//    }
//
//    public static FragmentTransactionAssert androidAssertThat(FragmentTransaction actual) {
//        return new FragmentTransactionAssert(actual);
//    }
//
//    public static InstrumentationActivityMonitorAssert androidAssertThat(Instrumentation.ActivityMonitor actual) {
//        return new InstrumentationActivityMonitorAssert(actual);
//    }
//
//    public static InstrumentationActivityResultAssert androidAssertThat(Instrumentation.ActivityResult actual) {
//        return new InstrumentationActivityResultAssert(actual);
//    }
//
//    public static KeyguardManagerAssert androidAssertThat(KeyguardManager actual) {
//        return new KeyguardManagerAssert(actual);
//    }
//
//    public static ListActivityAssert androidAssertThat(ListActivity actual) {
//        return new ListActivityAssert(actual);
//    }
//
//    public static ListFragmentAssert androidAssertThat(ListFragment actual) {
//        return new ListFragmentAssert(actual);
//    }
//
//    public static LoaderManagerAssert androidAssertThat(LoaderManager actual) {
//        return new LoaderManagerAssert(actual);
//    }
//
//    public static LocalActivityManagerAssert androidAssertThat(LocalActivityManager actual) {
//        return new LocalActivityManagerAssert(actual);
//    }
//
//    public static NotificationAssert androidAssertThat(Notification actual) {
//        return new NotificationAssert(actual);
//    }
//
//    public static PendingIntentAssert androidAssertThat(PendingIntent actual) {
//        return new PendingIntentAssert(actual);
//    }
//
//    public static ProgressDialogAssert androidAssertThat(ProgressDialog actual) {
//        return new ProgressDialogAssert(actual);
//    }
//
//    public static ServiceAssert androidAssertThat(Service actual) {
//        return new ServiceAssert(actual);
//    }
//
//    public static TaskStackBuilderAssert androidAssertThat(TaskStackBuilder actual) {
//        return new TaskStackBuilderAssert(actual);
//    }
//
//    public static UiModeManagerAssert androidAssertThat(UiModeManager actual) {
//        return new UiModeManagerAssert(actual);
//    }
//
//    public static BluetoothClassAssert androidAssertThat(BluetoothClass actual) {
//        return new BluetoothClassAssert(actual);
//    }
//
//    public static BluetoothDeviceAssert androidAssertThat(BluetoothDevice actual) {
//        return new BluetoothDeviceAssert(actual);
//    }
//
//    public static BluetoothGattCharacteristicAssert androidAssertThat(BluetoothGattCharacteristic actual) {
//        return new BluetoothGattCharacteristicAssert(actual);
//    }
//
//    public static BluetoothGattDescriptorAssert androidAssertThat(BluetoothGattDescriptor actual) {
//        return new BluetoothGattDescriptorAssert(actual);
//    }
//
//    public static BluetoothGattServiceAssert androidAssertThat(BluetoothGattService actual) {
//        return new BluetoothGattServiceAssert(actual);
//    }
//
//    public static AsyncTaskLoaderAssert androidAssertThat(AsyncTaskLoader actual) {
//        return new AsyncTaskLoaderAssert(actual);
//    }
//
//    public static ContentValuesAssert androidAssertThat(ContentValues actual) {
//        return new ContentValuesAssert(actual);
//    }
//
//    public static CursorLoaderAssert androidAssertThat(CursorLoader actual) {
//        return new CursorLoaderAssert(actual);
//    }
//
//    public static IntentAssert androidAssertThat(Intent actual) {
//        return new IntentAssert(actual);
//    }
//
//    public static LoaderAssert androidAssertThat(Loader actual) {
//        return new LoaderAssert(actual);
//    }
//
//    public static SharedPreferencesAssert androidAssertThat(SharedPreferences actual) {
//        return new SharedPreferencesAssert(actual);
//    }
//
//    public static ConfigurationAssert androidAssertThat(Configuration actual) {
//        return new ConfigurationAssert(actual);
//    }
//
//    public static AbstractCursor_Assert androidAssertThat(AbstractCursor actual) {
//        return new AbstractCursor_Assert(actual);
//    }
//
//    public static CursorAssert androidAssertThat(Cursor actual) {
//        return new CursorAssert(actual);
//    }
//
//    public static CursorWindowAssert androidAssertThat(CursorWindow actual) {
//        return new CursorWindowAssert(actual);
//    }
//
//    public static SqliteDatabaseAssert androidAssertThat(SQLiteDatabase actual) {
//        return new SqliteDatabaseAssert(actual);
//    }
//
//    public static GestureAssert androidAssertThat(Gesture actual) {
//        return new GestureAssert(actual);
//    }
//
//    public static GestureLibraryAssert androidAssertThat(GestureLibrary actual) {
//        return new GestureLibraryAssert(actual);
//    }
//
//    public static GestureOverlayViewAssert androidAssertThat(GestureOverlayView actual) {
//        return new GestureOverlayViewAssert(actual);
//    }
//
//    public static GesturePointAssert androidAssertThat(GesturePoint actual) {
//        return new GesturePointAssert(actual);
//    }
//
//    public static GestureStoreAssert androidAssertThat(GestureStore actual) {
//        return new GestureStoreAssert(actual);
//    }
//
//    public static GestureStrokeAssert androidAssertThat(GestureStroke actual) {
//        return new GestureStrokeAssert(actual);
//    }
//
//    public static OrientedBoundingBoxAssert androidAssertThat(OrientedBoundingBox actual) {
//        return new OrientedBoundingBoxAssert(actual);
//    }
//
//    public static PredictionAssert androidAssertThat(Prediction actual) {
//        return new PredictionAssert(actual);
//    }
//
//    public static BitmapAssert androidAssertThat(Bitmap actual) {
//        return new BitmapAssert(actual);
//    }
//
//    public static BitmapRegionDecoderAssert androidAssertThat(BitmapRegionDecoder actual) {
//        return new BitmapRegionDecoderAssert(actual);
//    }
//
//    public static CameraAssert androidAssertThat(Camera actual) {
//        return new CameraAssert(actual);
//    }
//
//    public static CanvasAssert androidAssertThat(Canvas actual) {
//        return new CanvasAssert(actual);
//    }
//
//    public static InterpolatorAssert androidAssertThat(Interpolator actual) {
//        return new InterpolatorAssert(actual);
//    }
//
//    public static MatrixAssert androidAssertThat(Matrix actual) {
//        return new MatrixAssert(actual);
//    }
//
//    public static MovieAssert androidAssertThat(Movie actual) {
//        return new MovieAssert(actual);
//    }
//
//    public static NinePatchAssert androidAssertThat(NinePatch actual) {
//        return new NinePatchAssert(actual);
//    }
//
//    public static PaintAssert androidAssertThat(Paint actual) {
//        return new PaintAssert(actual);
//    }
//
//    public static PathAssert androidAssertThat(Path actual) {
//        return new PathAssert(actual);
//    }
//
//    public static PathMeasureAssert androidAssertThat(PathMeasure actual) {
//        return new PathMeasureAssert(actual);
//    }
//
//    public static PictureAssert androidAssertThat(Picture actual) {
//        return new PictureAssert(actual);
//    }
//
//    public static PointAssert androidAssertThat(Point actual) {
//        return new PointAssert(actual);
//    }
//
//    public static PointFAssert androidAssertThat(PointF actual) {
//        return new PointFAssert(actual);
//    }
//
//    public static RectAssert androidAssertThat(Rect actual) {
//        return new RectAssert(actual);
//    }
//
//    public static RectFAssert androidAssertThat(RectF actual) {
//        return new RectFAssert(actual);
//    }
//
//    public static RegionAssert androidAssertThat(Region actual) {
//        return new RegionAssert(actual);
//    }
//
//    public static TypefaceAssert androidAssertThat(Typeface actual) {
//        return new TypefaceAssert(actual);
//    }
//
//    public static YuvImageAssert androidAssertThat(YuvImage actual) {
//        return new YuvImageAssert(actual);
//    }
//
//    public static AnimationDrawableAssert androidAssertThat(AnimationDrawable actual) {
//        return new AnimationDrawableAssert(actual);
//    }
//
//    public static BitmapDrawableAssert androidAssertThat(BitmapDrawable actual) {
//        return new BitmapDrawableAssert(actual);
//    }
//
//    public static ColorDrawableAssert androidAssertThat(ColorDrawable actual) {
//        return new ColorDrawableAssert(actual);
//    }
//
//    public static DrawableAssert androidAssertThat(Drawable actual) {
//        return new DrawableAssert(actual);
//    }
//
//    public static GradientDrawableAssert androidAssertThat(GradientDrawable actual) {
//        return new GradientDrawableAssert(actual);
//    }
//
//    public static LayerDrawableAssert androidAssertThat(LayerDrawable actual) {
//        return new LayerDrawableAssert(actual);
//    }
//
//    public static TransitionDrawableAssert androidAssertThat(TransitionDrawable actual) {
//        return new TransitionDrawableAssert(actual);
//    }
//
//    public static ShapeAssert androidAssertThat(Shape actual) {
//        return new ShapeAssert(actual);
//    }
//
//    public static SensorAssert androidAssertThat(Sensor actual) {
//        return new SensorAssert(actual);
//    }
//
//    public static SensorEventAssert androidAssertThat(SensorEvent actual) {
//        return new SensorEventAssert(actual);
//    }
//
//    public static UsbAccessoryAssert androidAssertThat(UsbAccessory actual) {
//        return new UsbAccessoryAssert(actual);
//    }
//
//    public static UsbDeviceAssert androidAssertThat(UsbDevice actual) {
//        return new UsbDeviceAssert(actual);
//    }
//
//    public static UsbDeviceConnectionAssert androidAssertThat(UsbDeviceConnection actual) {
//        return new UsbDeviceConnectionAssert(actual);
//    }
//
//    public static UsbEndpointAssert androidAssertThat(UsbEndpoint actual) {
//        return new UsbEndpointAssert(actual);
//    }
//
//    public static UsbInterfaceAssert androidAssertThat(UsbInterface actual) {
//        return new UsbInterfaceAssert(actual);
//    }
//
//    public static UsbRequestAssert androidAssertThat(UsbRequest actual) {
//        return new UsbRequestAssert(actual);
//    }
//
//    public static ExtractEditTextAssert androidAssertThat(ExtractEditText actual) {
//        return new ExtractEditTextAssert(actual);
//    }
//
//    public static AddressAssert androidAssertThat(Address actual) {
//        return new AddressAssert(actual);
//    }
//
//    public static CriteriaAssert androidAssertThat(Criteria actual) {
//        return new CriteriaAssert(actual);
//    }
//
//    public static GpsSatelliteAssert androidAssertThat(GpsSatellite actual) {
//        return new GpsSatelliteAssert(actual);
//    }
//
//    public static GpsStatusAssert androidAssertThat(GpsStatus actual) {
//        return new GpsStatusAssert(actual);
//    }
//
//    public static LocationAssert androidAssertThat(Location actual) {
//        return new LocationAssert(actual);
//    }
//
//    public static LocationProviderAssert androidAssertThat(LocationProvider actual) {
//        return new LocationProviderAssert(actual);
//    }
//
//    public static AsyncTaskAssert androidAssertThat(AsyncTask actual) {
//        return new AsyncTaskAssert(actual);
//    }
//
//    public static BundleAssert androidAssertThat(Bundle actual) {
//        return new BundleAssert(actual);
//    }
//
//    public static PowerManagerAssert androidAssertThat(PowerManager actual) {
//        return new PowerManagerAssert(actual);
//    }
//
//    public static VibratorAssert androidAssertThat(Vibrator actual) {
//        return new VibratorAssert(actual);
//    }
//
//    public static CheckBoxPreferenceAssert androidAssertThat(CheckBoxPreference actual) {
//        return new CheckBoxPreferenceAssert(actual);
//    }
//
//    public static DialogPreferenceAssert androidAssertThat(DialogPreference actual) {
//        return new DialogPreferenceAssert(actual);
//    }
//
//    public static EditTextPreferenceAssert androidAssertThat(EditTextPreference actual) {
//        return new EditTextPreferenceAssert(actual);
//    }
//
//    public static ListPreferenceAssert androidAssertThat(ListPreference actual) {
//        return new ListPreferenceAssert(actual);
//    }
//
//    public static MultiSelectListPreferenceAssert androidAssertThat(MultiSelectListPreference actual) {
//        return new MultiSelectListPreferenceAssert(actual);
//    }
//
//    public static PreferenceActivityAssert androidAssertThat(PreferenceActivity actual) {
//        return new PreferenceActivityAssert(actual);
//    }
//
//    public static PreferenceAssert androidAssertThat(Preference actual) {
//        return new PreferenceAssert(actual);
//    }
//
//    public static PreferenceGroupAssert androidAssertThat(PreferenceGroup actual) {
//        return new PreferenceGroupAssert(actual);
//    }
//
//    public static PreferenceScreenAssert androidAssertThat(PreferenceScreen actual) {
//        return new PreferenceScreenAssert(actual);
//    }
//
//    public static RingtonePreferenceAssert androidAssertThat(RingtonePreference actual) {
//        return new RingtonePreferenceAssert(actual);
//    }
//
//    public static SwitchPreferenceAssert androidAssertThat(SwitchPreference actual) {
//        return new SwitchPreferenceAssert(actual);
//    }
//
//    public static TwoStatePreferenceAssert androidAssertThat(TwoStatePreference actual) {
//        return new TwoStatePreferenceAssert(actual);
//    }
//
//    public static CellIdentityCdmaAssert androidAssertThat(CellIdentityCdma actual) {
//        return new CellIdentityCdmaAssert(actual);
//    }
//
//    public static CellIdentityGsmAssert androidAssertThat(CellIdentityGsm actual) {
//        return new CellIdentityGsmAssert(actual);
//    }
//
//    public static CellIdentityLteAssert androidAssertThat(CellIdentityLte actual) {
//        return new CellIdentityLteAssert(actual);
//    }
//
//    public static CellIdentityWcdmaAssert androidAssertThat(CellIdentityWcdma actual) {
//        return new CellIdentityWcdmaAssert(actual);
//    }
//
//    public static CellInfoAssert androidAssertThat(CellInfo actual) {
//        return new CellInfoAssert(actual);
//    }
//
//    public static CellInfoCdmaAssert androidAssertThat(CellInfoCdma actual) {
//        return new CellInfoCdmaAssert(actual);
//    }
//
//    public static CellInfoGsmAssert androidAssertThat(CellInfoGsm actual) {
//        return new CellInfoGsmAssert(actual);
//    }
//
//    public static CellInfoLteAssert androidAssertThat(CellInfoLte actual) {
//        return new CellInfoLteAssert(actual);
//    }
//
//    public static CellInfoWcdmaAssert androidAssertThat(CellInfoWcdma actual) {
//        return new CellInfoWcdmaAssert(actual);
//    }
//
//    public static CellSignalStrengthCdmaAssert androidAssertThat(CellSignalStrengthCdma actual) {
//        return new CellSignalStrengthCdmaAssert(actual);
//    }
//
//    public static CellSignalStrengthGsmAssert androidAssertThat(CellSignalStrengthGsm actual) {
//        return new CellSignalStrengthGsmAssert(actual);
//    }
//
//    public static CellSignalStrengthLteAssert androidAssertThat(CellSignalStrengthLte actual) {
//        return new CellSignalStrengthLteAssert(actual);
//    }
//
//    public static CellSignalStrengthWcdmaAssert androidAssertThat(CellSignalStrengthWcdma actual) {
//        return new CellSignalStrengthWcdmaAssert(actual);
//    }
//
//    public static NeighboringCellInfoAssert androidAssertThat(NeighboringCellInfo actual) {
//        return new NeighboringCellInfoAssert(actual);
//    }
//
//    public static ServiceStateAssert androidAssertThat(ServiceState actual) {
//        return new ServiceStateAssert(actual);
//    }
//
//    public static SignalStrengthAssert androidAssertThat(SignalStrength actual) {
//        return new SignalStrengthAssert(actual);
//    }
//
//    public static SmsMessageAssert androidAssertThat(SmsMessage actual) {
//        return new SmsMessageAssert(actual);
//    }
//
//    public static TelephonyManagerAssert androidAssertThat(TelephonyManager actual) {
//        return new TelephonyManagerAssert(actual);
//    }
//
//    public static CdmaCellLocationAssert androidAssertThat(CdmaCellLocation actual) {
//        return new CdmaCellLocationAssert(actual);
//    }
//
//    public static GsmCellLocationAssert androidAssertThat(GsmCellLocation actual) {
//        return new GsmCellLocationAssert(actual);
//    }
//
//    public static BidiFormatterAssert androidAssertThat(BidiFormatter actual) {
//        return new BidiFormatterAssert(actual);
//    }
//
//    public static <K, V> ArrayMapAssert<K, V> androidAssertThat(ArrayMap<K, V> actual) {
//        return new ArrayMapAssert(actual);
//    }
//
//    public static AtomicFileAssert androidAssertThat(AtomicFile actual) {
//        return new AtomicFileAssert(actual);
//    }
//
//    public static AttributeSetAssert androidAssertThat(AttributeSet actual) {
//        return new AttributeSetAssert(actual);
//    }
//
//    public static DisplayMetricsAssert androidAssertThat(DisplayMetrics actual) {
//        return new DisplayMetricsAssert(actual);
//    }
//
//    public static LongSparseArrayAssert androidAssertThat(LongSparseArray actual) {
//        return new LongSparseArrayAssert(actual);
//    }
//
//    public static <K, V> LruCacheAssert<K, V> androidAssertThat(LruCache<K, V> actual) {
//        return new LruCacheAssert(actual);
//    }
//
//    public static <F, S> PairAssert<F, S> androidAssertThat(Pair<F, S> actual) {
//        return new PairAssert(actual);
//    }
//
//    public static <T, V> PropertyAssert<T, V> androidAssertThat(Property<T, V> actual) {
//        return new PropertyAssert(actual);
//    }
//
//    public static <E> SparseArrayAssert<E> androidAssertThat(SparseArray<E> actual) {
//        return new SparseArrayAssert(actual);
//    }
//
//    public static SparseBooleanArrayAssert androidAssertThat(SparseBooleanArray actual) {
//        return new SparseBooleanArrayAssert(actual);
//    }
//
//    public static SparseIntArrayAssert androidAssertThat(SparseIntArray actual) {
//        return new SparseIntArrayAssert(actual);
//    }
//
//    public static SparseLongArrayAssert androidAssertThat(SparseLongArray actual) {
//        return new SparseLongArrayAssert(actual);
//    }
//
//    public static ActionModeAssert androidAssertThat(ActionMode actual) {
//        return new ActionModeAssert(actual);
//    }
//
//    public static ActionProviderAssert androidAssertThat(ActionProvider actual) {
//        return new ActionProviderAssert(actual);
//    }
//
//    public static DisplayAssert androidAssertThat(Display actual) {
//        return new DisplayAssert(actual);
//    }
//
//    public static DragEventAssert androidAssertThat(DragEvent actual) {
//        return new DragEventAssert(actual);
//    }
//
//    public static KeyCharacterMapAssert androidAssertThat(KeyCharacterMap actual) {
//        return new KeyCharacterMapAssert(actual);
//    }
//
//    public static KeyEventAssert androidAssertThat(KeyEvent actual) {
//        return new KeyEventAssert(actual);
//    }
//
//    public static MenuAssert androidAssertThat(Menu actual) {
//        return new MenuAssert(actual);
//    }
//
//    public static MenuItemAssert androidAssertThat(MenuItem actual) {
//        return new MenuItemAssert(actual);
//    }
//
//    public static OrientationEventListenerAssert androidAssertThat(OrientationEventListener actual) {
//        return new OrientationEventListenerAssert(actual);
//    }
//
//    public static ScaleGestureDetectorAssert androidAssertThat(ScaleGestureDetector actual) {
//        return new ScaleGestureDetectorAssert(actual);
//    }
//
//    public static SurfaceAssert androidAssertThat(Surface actual) {
//        return new SurfaceAssert(actual);
//    }
//
//    public static TextureViewAssert androidAssertThat(TextureView actual) {
//        return new TextureViewAssert(actual);
//    }
//
//    public static VelocityTrackerAssert androidAssertThat(VelocityTracker actual) {
//        return new VelocityTrackerAssert(actual);
//    }
//
//    public static ViewAssert androidAssertThat(View actual) {
//        return new ViewAssert(actual);
//    }
//
//    public static ViewConfigurationAssert androidAssertThat(ViewConfiguration actual) {
//        return new ViewConfigurationAssert(actual);
//    }
//
//    public static ViewGroupAssert androidAssertThat(ViewGroup actual) {
//        return new ViewGroupAssert(actual);
//    }
//
//    public static ViewGroupLayoutParamsAssert androidAssertThat(ViewGroup.LayoutParams actual) {
//        return new ViewGroupLayoutParamsAssert(actual);
//    }
//
//    public static ViewGroupMarginLayoutParamsAssert androidAssertThat(ViewGroup.MarginLayoutParams actual) {
//        return new ViewGroupMarginLayoutParamsAssert(actual);
//    }
//
//    public static ViewPropertyAnimatorAssert androidAssertThat(ViewPropertyAnimator actual) {
//        return new ViewPropertyAnimatorAssert(actual);
//    }
//
//    public static ViewStubAssert androidAssertThat(ViewStub actual) {
//        return new ViewStubAssert(actual);
//    }
//
//    public static ViewTreeObserverAssert androidAssertThat(ViewTreeObserver actual) {
//        return new ViewTreeObserverAssert(actual);
//    }
//
//    public static WindowAssert androidAssertThat(Window actual) {
//        return new WindowAssert(actual);
//    }
//
//    public static AccessibilityEventAssert androidAssertThat(AccessibilityEvent actual) {
//        return new AccessibilityEventAssert(actual);
//    }
//
//    public static AccessibilityManagerAssert androidAssertThat(AccessibilityManager actual) {
//        return new AccessibilityManagerAssert(actual);
//    }
//
//    public static AccessibilityNodeInfoAssert androidAssertThat(AccessibilityNodeInfo actual) {
//        return new AccessibilityNodeInfoAssert(actual);
//    }
//
//    public static AccessibilityRecordAssert androidAssertThat(AccessibilityRecord actual) {
//        return new AccessibilityRecordAssert(actual);
//    }
//
//    public static AnimationAssert androidAssertThat(Animation actual) {
//        return new AnimationAssert(actual);
//    }
//
//    public static AnimationSetAssert androidAssertThat(AnimationSet actual) {
//        return new AnimationSetAssert(actual);
//    }
//
//    public static GridLayoutAnimationControllerAssert androidAssertThat(GridLayoutAnimationController actual) {
//        return new GridLayoutAnimationControllerAssert(actual);
//    }
//
//    public static LayoutAnimationControllerAssert androidAssertThat(LayoutAnimationController actual) {
//        return new LayoutAnimationControllerAssert(actual);
//    }
//
//    public static TransformationAssert androidAssertThat(Transformation actual) {
//        return new TransformationAssert(actual);
//    }
//
//    public static WebViewAssert androidAssertThat(WebView actual) {
//        return new WebViewAssert(actual);
//    }
//
//    public static AbsListViewAssert androidAssertThat(AbsListView actual) {
//        return new AbsListViewAssert(actual);
//    }
//
//    public static AbsSeekBarAssert androidAssertThat(AbsSeekBar actual) {
//        return new AbsSeekBarAssert(actual);
//    }
//
//    public static AbsSpinnerAssert androidAssertThat(AbsSpinner actual) {
//        return new AbsSpinnerAssert(actual);
//    }
//
//    public static AbsoluteLayoutAssert androidAssertThat(AbsoluteLayout actual) {
//        return new AbsoluteLayoutAssert(actual);
//    }
//
//    public static AdapterAssert androidAssertThat(Adapter actual) {
//        return new AdapterAssert(actual);
//    }
//
//    public static AdapterViewAssert androidAssertThat(AdapterView actual) {
//        return new AdapterViewAssert(actual);
//    }
//
//    public static ArrayAdapterAssert androidAssertThat(ArrayAdapter actual) {
//        return new ArrayAdapterAssert(actual);
//    }
//
//    public static AutoCompleteTextViewAssert androidAssertThat(AutoCompleteTextView actual) {
//        return new AutoCompleteTextViewAssert(actual);
//    }
//
//    public static CalendarViewAssert androidAssertThat(CalendarView actual) {
//        return new CalendarViewAssert(actual);
//    }
//
//    public static CheckedTextViewAssert androidAssertThat(CheckedTextView actual) {
//        return new CheckedTextViewAssert(actual);
//    }
//
//    public static ChronometerAssert androidAssertThat(Chronometer actual) {
//        return new ChronometerAssert(actual);
//    }
//
//    public static CompoundButtonAssert androidAssertThat(CompoundButton actual) {
//        return new CompoundButtonAssert(actual);
//    }
//
//    public static CursorAdapterAssert androidAssertThat(CursorAdapter actual) {
//        return new CursorAdapterAssert(actual);
//    }
//
//    public static DatePickerAssert androidAssertThat(DatePicker actual) {
//        return new DatePickerAssert(actual);
//    }
//
//    public static ExpandableListViewAssert androidAssertThat(ExpandableListView actual) {
//        return new ExpandableListViewAssert(actual);
//    }
//
//    public static FrameLayoutAssert androidAssertThat(FrameLayout actual) {
//        return new FrameLayoutAssert(actual);
//    }
//
//    public static GridLayoutAssert androidAssertThat(GridLayout actual) {
//        return new GridLayoutAssert(actual);
//    }
//
//    public static GridViewAssert androidAssertThat(GridView actual) {
//        return new GridViewAssert(actual);
//    }
//
//    public static HeaderViewListAdapterAssert androidAssertThat(HeaderViewListAdapter actual) {
//        return new HeaderViewListAdapterAssert(actual);
//    }
//
//    public static HorizontalScrollViewAssert androidAssertThat(HorizontalScrollView actual) {
//        return new HorizontalScrollViewAssert(actual);
//    }
//
//    public static ImageViewAssert androidAssertThat(ImageView actual) {
//        return new ImageViewAssert(actual);
//    }
//
//    public static LinearLayoutAssert androidAssertThat(LinearLayout actual) {
//        return new LinearLayoutAssert(actual);
//    }
//
//    public static ListAdapterAssert androidAssertThat(ListAdapter actual) {
//        return new ListAdapterAssert(actual);
//    }
//
//    public static ListPopupWindowAssert androidAssertThat(ListPopupWindow actual) {
//        return new ListPopupWindowAssert(actual);
//    }
//
//    public static ListViewAssert androidAssertThat(ListView actual) {
//        return new ListViewAssert(actual);
//    }
//
//    public static MediaControllerAssert androidAssertThat(MediaController actual) {
//        return new MediaControllerAssert(actual);
//    }
//
//    public static NumberPickerAssert androidAssertThat(NumberPicker actual) {
//        return new NumberPickerAssert(actual);
//    }
//
//    public static PopupWindowAssert androidAssertThat(PopupWindow actual) {
//        return new PopupWindowAssert(actual);
//    }
//
//    public static ProgressBarAssert androidAssertThat(ProgressBar actual) {
//        return new ProgressBarAssert(actual);
//    }
//
//    public static RadioGroupAssert androidAssertThat(RadioGroup actual) {
//        return new RadioGroupAssert(actual);
//    }
//
//    public static RatingBarAssert androidAssertThat(RatingBar actual) {
//        return new RatingBarAssert(actual);
//    }
//
//    public static RelativeLayoutAssert androidAssertThat(RelativeLayout actual) {
//        return new RelativeLayoutAssert(actual);
//    }
//
//    public static ScrollViewAssert androidAssertThat(ScrollView actual) {
//        return new ScrollViewAssert(actual);
//    }
//
//    public static SearchViewAssert androidAssertThat(SearchView actual) {
//        return new SearchViewAssert(actual);
//    }
//
//    public static SimpleAdapterAssert androidAssertThat(SimpleAdapter actual) {
//        return new SimpleAdapterAssert(actual);
//    }
//
//    public static SimpleCursorAdapterAssert androidAssertThat(SimpleCursorAdapter actual) {
//        return new SimpleCursorAdapterAssert(actual);
//    }
//
//    public static SlidingDrawerAssert androidAssertThat(SlidingDrawer actual) {
//        return new SlidingDrawerAssert(actual);
//    }
//
//    public static SpinnerAssert androidAssertThat(Spinner actual) {
//        return new SpinnerAssert(actual);
//    }
//
//    public static SwitchAssert androidAssertThat(Switch actual) {
//        return new SwitchAssert(actual);
//    }
//
//    public static TabHostAssert androidAssertThat(TabHost actual) {
//        return new TabHostAssert(actual);
//    }
//
//    public static TabWidgetAssert androidAssertThat(TabWidget actual) {
//        return new TabWidgetAssert(actual);
//    }
//
//    public static TableLayoutAssert androidAssertThat(TableLayout actual) {
//        return new TableLayoutAssert(actual);
//    }
//
//    public static TableRowAssert androidAssertThat(TableRow actual) {
//        return new TableRowAssert(actual);
//    }
//
//    public static TextViewAssert androidAssertThat(TextView actual) {
//        return new TextViewAssert(actual);
//    }
//
//    public static TimePickerAssert androidAssertThat(TimePicker actual) {
//        return new TimePickerAssert(actual);
//    }
//
//    public static ToastAssert androidAssertThat(Toast actual) {
//        return new ToastAssert(actual);
//    }
//
//    public static ToggleButtonAssert androidAssertThat(ToggleButton actual) {
//        return new ToggleButtonAssert(actual);
//    }
//
//    public static VideoViewAssert androidAssertThat(VideoView actual) {
//        return new VideoViewAssert(actual);
//    }
//
//    public static ViewAnimatorAssert androidAssertThat(ViewAnimator actual) {
//        return new ViewAnimatorAssert(actual);
//    }
//
//    public static ViewFlipperAssert androidAssertThat(ViewFlipper actual) {
//        return new ViewFlipperAssert(actual);
//    }
//
//    public static ViewSwitcherAssert androidAssertThat(ViewSwitcher actual) {
//        return new ViewSwitcherAssert(actual);
//    }
//
//    public static WrapperListAdapterAssert androidAssertThat(WrapperListAdapter actual) {
//        return new WrapperListAdapterAssert(actual);
//    }
//
//    private Assertions() {
//        throw new AssertionError("No instances.");
//    }
//
//}
