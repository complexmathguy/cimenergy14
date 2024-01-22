/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * VisibilityLayer business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VisibilityLayer related services in the case of a
 *       VisibilityLayer business related service failing.
 *   <li>Exposes a simpler, uniform VisibilityLayer interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill VisibilityLayer business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VisibilityLayerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VisibilityLayerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VisibilityLayer Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VisibilityLayerBusinessDelegate
   */
  public static VisibilityLayerBusinessDelegate getVisibilityLayerInstance() {
    return (new VisibilityLayerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVisibilityLayer(CreateVisibilityLayerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVisibilityLayerId() == null) command.setVisibilityLayerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVisibilityLayerCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVisibilityLayerCommand of VisibilityLayer is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VisibilityLayer - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVisibilityLayerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVisibilityLayer(UpdateVisibilityLayerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVisibilityLayerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VisibilityLayer - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVisibilityLayerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVisibilityLayerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVisibilityLayerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete VisibilityLayer using Id = " + command.getVisibilityLayerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VisibilityLayer via VisibilityLayerFetchOneSummary
   *
   * @param summary VisibilityLayerFetchOneSummary
   * @return VisibilityLayerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VisibilityLayer getVisibilityLayer(VisibilityLayerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("VisibilityLayerFetchOneSummary arg cannot be null");

    VisibilityLayer entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VisibilityLayer
      // --------------------------------------
      CompletableFuture<VisibilityLayer> futureEntity =
          queryGateway.query(
              new FindVisibilityLayerQuery(
                  new LoadVisibilityLayerFilter(summary.getVisibilityLayerId())),
              ResponseTypes.instanceOf(VisibilityLayer.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate VisibilityLayer with id " + summary.getVisibilityLayerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VisibilityLayers
   *
   * @return List<VisibilityLayer>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VisibilityLayer> getAllVisibilityLayer() throws ProcessingException {
    List<VisibilityLayer> list = null;

    try {
      CompletableFuture<List<VisibilityLayer>> futureList =
          queryGateway.query(
              new FindAllVisibilityLayerQuery(),
              ResponseTypes.multipleInstancesOf(VisibilityLayer.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VisibilityLayer";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign DrawingOrder on VisibilityLayer
   *
   * @param command AssignDrawingOrderToVisibilityLayerCommand
   * @exception ProcessingException
   */
  public void assignDrawingOrder(AssignDrawingOrderToVisibilityLayerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVisibilityLayerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    VisibilityLayerBusinessDelegate parentDelegate =
        VisibilityLayerBusinessDelegate.getVisibilityLayerInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign DrawingOrder on VisibilityLayer
   *
   * @param command UnAssignDrawingOrderFromVisibilityLayerCommand
   * @exception ProcessingException
   */
  public void unAssignDrawingOrder(UnAssignDrawingOrderFromVisibilityLayerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign DrawingOrder on VisibilityLayer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add VisibilityLayer to VisibilityLayers
   *
   * @param command AssignVisibilityLayersToVisibilityLayerCommand
   * @exception ProcessingException
   */
  public void addToVisibilityLayers(AssignVisibilityLayersToVisibilityLayerCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getVisibilityLayerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
            .delegate.VisibilityLayerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile
                .diagramlayout.delegate.VisibilityLayerBusinessDelegate
                .getVisibilityLayerInstance();
    VisibilityLayerBusinessDelegate parentDelegate =
        VisibilityLayerBusinessDelegate.getVisibilityLayerInstance();
    UUID childId = command.getAddTo().getVisibilityLayerId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a VisibilityLayer as VisibilityLayers to VisibilityLayer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove VisibilityLayer from VisibilityLayers
   *
   * @param command RemoveVisibilityLayersFromVisibilityLayerCommand
   * @exception ProcessingException
   */
  public void removeFromVisibilityLayers(RemoveVisibilityLayersFromVisibilityLayerCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
            .delegate.VisibilityLayerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile
                .diagramlayout.delegate.VisibilityLayerBusinessDelegate
                .getVisibilityLayerInstance();
    UUID childId = command.getRemoveFrom().getVisibilityLayerId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VisibilityLayerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VisibilityLayer
   */
  private VisibilityLayer load(UUID id) throws ProcessingException {
    visibilityLayer =
        VisibilityLayerBusinessDelegate.getVisibilityLayerInstance()
            .getVisibilityLayer(new VisibilityLayerFetchOneSummary(id));
    return visibilityLayer;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VisibilityLayer visibilityLayer = null;
  private static final Logger LOGGER =
      Logger.getLogger(VisibilityLayerBusinessDelegate.class.getName());
}
