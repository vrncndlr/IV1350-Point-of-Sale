// package main.se.kth.iv1350.pos.model;

// import java.util.ArrayList;

// import main.se.kth.iv1350.pos.DTO.ItemDTO;
// import main.se.kth.iv1350.pos.integration.InventorySystem;

// /**
//  * ShoppingCart contains the items in the current sale.
//  */
// public class ShoppingCart {
//     private InventorySystem inventoryHandler;
//     private ArrayList<Item> listOfItems;
//     private boolean firstItemEver = true;

//     /**
//      * Creates a new instance of a <code>CheckoutCart</code>.
//      * @param inventoryHandler Handler of an external inventory system.
//      */
//     public ShoppingCart(InventorySystem inventoryHandler) {
//         this.inventoryHandler = inventoryHandler;
//         this.listOfItems = new ArrayList<Item>();
//     }

//     /**
//      * Checks if the requested <code>Item</code> exists, and if so, adds the <code>Item</code> to the cart.
//      * @param itemRequest a proto-item, all values null except for <code>identifier</code>.
//      * @return ItemDTO either is null, indicating no match in the database or contains all data of the requested <code>Item</code>.
//      */
//     public ItemDTO addItem(ItemDTO itemRequest){
//         ItemDTO scannedItem = inventoryHandler.createItemDTO(itemRequest);
//         Item item;
//         if(scannedItem != null){
//             item = new Item(scannedItem);
//             addItemToCheckoutCart(item);
//         }
//         return scannedItem;
//     }

//     /**
//      * Add the scanned <code>ItemDTO</code> to the cart. If an item already exists in the cart the quantity increases. 
//      * @param itemBeingAddedToCart the scanned item
//      */
//     private void addItemToCheckoutCart(Item itemBeingAddedToCart) {
//         if(firstItemEver){
//             listOfItems.add(itemBeingAddedToCart);   
//             firstItemEver = false; 
//         }
//         else {
//             int duplicateItemPosition = findItemPositionInArray(itemBeingAddedToCart, listOfItems);
//         if(duplicateItemPosition >= 0)
//             incrementItemInCart(itemBeingAddedToCart, duplicateItemPosition);
//         else
//             listOfItems.add(itemBeingAddedToCart);
//         }      
//     }

//     /**
//      * Increase the<code>quantity</code> of a scanned <code>ItemDTO</code> already existing in the cart.
//      * @param itemBeingAddedToCart the scanned item.
//      * @param duplicateItemPosition the element position of the scanned item to be increased.
//      */
//     private void incrementItemInCart(Item itemBeingAddedToCart, int duplicateItemPosition){
//         Item combinedItems = listOfItems.get(duplicateItemPosition);
//         combinedItems.setQuantity(combinedItems.getQuantity() + itemBeingAddedToCart.getQuantity());
//         listOfItems.set(duplicateItemPosition, combinedItems);
//     }

//     /**
//      * Goes through an Arraylist of <code>Item</code> and checks if there is an <code>Item</code> of the same type already in the list. That <code>Item</code>'s element position is returned.
//      * @param itemBeingAddedToCart Item being matched to Items in <code>listOfItems</code>.
//      * @return an int of a given Item's position in the list, otherwise -1 for an Item not found.
//      */
//     private int findItemPositionInArray(Item itemBeingAddedToCart, ArrayList<Item> listOfItems){
//         for(int i = 0; i < listOfItems.size(); i++){
//             if(itemBeingAddedToCart.getItemID() == listOfItems.get(i).getItemID()){
//                 return i;
//             }
//         }
//         return -1;
//     }

//     /**
//     * Get the <code>listOfItems</code> in the current cart.
//     * @return the current shoppinglist
//     */
//     protected final ArrayList<Item> getListOfItems() {
//         return listOfItems;
//     }

// }