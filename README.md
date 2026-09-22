<div align="center">

<img src="https://socialify.git.ci/crimera/piko/image?forks=1&language=1&name=1&owner=1&pattern=Circuit%20Board&stargazers=1&theme=Auto" alt="piko" width="640" height="320" />

<h1>
    pne cli - Morphe patches focused on Instagram<br>
</h1>

</div>

## 🕹️ Usage

Patches use [Morphe](https://morphe.software).

### Morphe Manager

1. Tap Instagram app icon in Morphe
2. Download original Instagram APKM file from ApkMirror. Do _not_ unspilt or modify the file, Morphe patches APKM directly
3. Select your desired patches (Ghost mode, theme, ephemeral media, downloader, etc.)
4. Wait for patching to complete, install

### Morphe CLI

```sh
java -jar cli.jar patch --patches pne-cli.mpp input.apkm
```

## ⚙️ Patch Details

<!-- PATCHES_START -->
<details open>
<summary>📦 Instagram</summary>
<br>

**🎯 Supported versions:**

| 439.0.0.37.89 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Add settings](#add-settings) | Adds settings to control preferences are patching |  |
| [Allow user network certificate](#allow-user-network-certificate) | Allows user network certificate for whitehat testing |  |
| [Change like animation](#change-like-animation) | Change the animation to one from existing Rings like animations |  |
| [Change version code](#change-version-code) | Changes the version code of the app. This will turn off app store updates and allows downgrading an existing app install to an older app version. | • Version code |
| [Clone](#clone) | Changes the package name and the app name. This allows you to install the patched app alongside the original Instagram app.<br>Caution: Do not select the official Morphe's "Change package name" universal patch. | • Package name<br>• App name |
| [Copy comment](#copy-comment) | Adds a button to copy comments on posts and reels. |  |
| [Custom sharing domain](#custom-sharing-domain) | Allows for using custom domains when sharing posts, reels and stories. |  |
| [Customise story ring size](#customise-story-ring-size) |  |  |
| [Customise story timestamp](#customise-story-timestamp) | Customise the timestamp that shows when the story was posted |  |
| [Disable Reels scrolling](#disable-reels-scrolling) | Disables the endless scrolling behavior in Instagram Reels, preventing swiping to the next Reel. Note: On a clean install, the 'Tip' animation may appear but will stop on its own after a few seconds. |  |
| [Disable ads](#disable-ads) |  |  |
| [Disable analytics](#disable-analytics) | Block analytics that are sent to Instagram/Facebook servers. |  |
| [Disable comments](#disable-comments) |  |  |
| [Disable discover people](#disable-discover-people) | Disables discover people section on user profile |  |
| [Disable double tap like](#disable-double-tap-like) | Disable double tap like on post, reel, comment and message |  |
| [Disable explore](#disable-explore) |  |  |
| [Disable highlights](#disable-highlights) |  |  |
| [Disable onboarding permission prompts](#disable-onboarding-permission-prompts) | Prevents contacts and location permission onboarding prompts from appearing. |  |
| [Disable screenshot detection](#disable-screenshot-detection) | Disables screenshots detection in DM |  |
| [Disable stories](#disable-stories) |  |  |
| [Disable story flipping](#disable-story-flipping) | Disable automatic flipping/moving to next story |  |
| [Disable swipe to create](#disable-swipe-to-create) | Prevents opening the creation screen by swiping right on the home tab. |  |
| [Disable typing status](#disable-typing-status) |  |  |
| [Disable video autoplay](#disable-video-autoplay) |  |  |
| [Download media](#download-media) | Adds ability to download posts, reels, stories and highlights |  |
| [Download voice message](#download-voice-message) | Enables ability to download voice messages |  |
| [External downloader](#external-downloader) | Adds support to share post links directly to external downloader |  |
| [Filter stories](#filter-stories) | Filter stories to hide based on different categories |  |
| [Friendship status indicator](#friendship-status-indicator) | Adds a follows you back status label on the profile page andshows a detailed friendship status breakdown on click |  |
| [Hide group creation button on sharesheet](#hide-group-creation-button-on-sharesheet) |  |  |
| [Hide navigation buttons](#hide-navigation-buttons) | Hides navigation bar buttons, such as the Reels and Create button. |  |
| [Hide notes tray](#hide-notes-tray) | Hides notes tray in DM section |  |
| [Hide reshare button](#hide-reshare-button) | Hides the reshare button from both posts and reels. |  |
| [Hide stories tray](#hide-stories-tray) | Hides stories tray from main feed. |  |
| [Hide suggested content](#hide-suggested-content) | Hides suggested stories, reels, threads (Suggested posts will still be shown). |  |
| [Improve image viewing](#improve-image-viewing) | Fetches max resolution images from server. |  |
| [Limit feed to following profiles](#limit-feed-to-following-profiles) | Filters the home feed to display only content from profiles you follow. |  |
| [Loop story](#loop-story) | Replay the current story when it ends |  |
| [Make ephemeral media permanent](#make-ephemeral-media-permanent) | Changes unexpired view once, view twice media to permanent view. |  |
| [Mark chat as read manually](#mark-chat-as-read-manually) | Adds option to mark a thread aka message as read manually |  |
| [More options on post](#more-options-on-post) | Adds an overflow menu button to get more options on post/reels, like copy description, copy username etc |  |
| [More options on profile](#more-options-on-profile) | Adds a new button to handle user related data like copy handle, download profile picture etc |  |
| [Open links externally](#open-links-externally) | Changes links to always open in your external browser, instead of the in-app browser. |  |
| [Recommended flags](#recommended-flags) | Developer flags suggested by the community |  |
| [Remove build expired popup](#remove-build-expired-popup) | Removes the popup that appears after a while, when the app version ages. |  |
| [Remove empty bottom space](#remove-empty-bottom-space) | Removes empty space below bottom navigation bar |  |
| [Sanitize share links](#sanitize-share-links) |  |  |
| [Save deleted messages](#save-deleted-messages) | Captures incoming DMs locally as they arrive from the server and marks them when the sender deletes them. |  |
| [Save media comment](#save-media-comment) | Adds a button to save media comments on posts and reels. |  |
| [Stories audio autoplay](#stories-audio-autoplay) |  |  |
| [Theme](#theme) | Adds Material You and AMOLED controls to Piko settings on Android 12 and later. On Android 8–11, it applies a fixed Material You-style theme or an optional AMOLED theme. | • Pure-black AMOLED theme for Android 8–11 |
| [Unlock Plus benefits](#unlock-plus-benefits) | Unlocks 'Plus' subscription benefits that are checked locally. USE IT AT YOUR OWN RISK |  |
| [Unlock developer options](#unlock-developer-options) | Unlocks developer option by long pressing home icon |  |
| [Unlock employee options](#unlock-employee-options) | Unlocks all options using by employee for debugging |  |
| [Validate links](#validate-links) | Fixes app crashing issue while opening links from a different app |  |
| [View DMs anonymously](#view-dms-anonymously) |  |  |
| [View live anonymously](#view-live-anonymously) |  |  |
| [View stories anonymously](#view-stories-anonymously) |  |  |
| [View story mentions](#view-story-mentions) | Add option to view visible and hidden story mentions. |  |

</details>

<!-- PATCHES_END -->

## 🛠️ Building

To build Piko Patches, follow the [Morphe documentation](https://github.com/MorpheApp/morphe-documentation).

## ✨ Stargazers over time

<p align="center">
    <img src="https://starchart.cc/crimera/piko.svg?variant=light" alt="piko" width="640" height="320" />
</p>

## License

[![GNU GPLv3 Image](https://www.gnu.org/graphics/gplv3-127x51.png)](http://www.gnu.org/licenses/gpl-3.0.en.html)

These patches are fully FOSS redistributable and modifiable under the [GNU General Public License v3](https://www.gnu.org/licenses/gpl.html) or later.
