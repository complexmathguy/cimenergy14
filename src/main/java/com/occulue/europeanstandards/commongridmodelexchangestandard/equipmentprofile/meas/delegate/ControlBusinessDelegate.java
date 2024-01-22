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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator.*;
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
 * Control business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Control related services in the case of a Control business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Control interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Control business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ControlBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ControlBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Control Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ControlBusinessDelegate
   */
  public static ControlBusinessDelegate getControlInstance() {
    return (new ControlBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createControl(CreateControlCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getControlId() == null) command.setControlId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateControlCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateControlCommand of Control is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Control - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateControlCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateControl(UpdateControlCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateControlCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Control - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteControlCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteControlCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteControlCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Control using Id = " + command.getControlId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Control via ControlFetchOneSummary
   *
   * @param summary ControlFetchOneSummary
   * @return ControlFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Control getControl(ControlFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ControlFetchOneSummary arg cannot be null");

    Control entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ControlValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Control
      // --------------------------------------
      CompletableFuture<Control> futureEntity =
          queryGateway.query(
              new FindControlQuery(new LoadControlFilter(summary.getControlId())),
              ResponseTypes.instanceOf(Control.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Control with id " + summary.getControlId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Controls
   *
   * @return List<Control>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Control> getAllControl() throws ProcessingException {
    List<Control> list = null;

    try {
      CompletableFuture<List<Control>> futureList =
          queryGateway.query(
              new FindAllControlQuery(), ResponseTypes.multipleInstancesOf(Control.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Control";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign ControlType on Control
   *
   * @param command AssignControlTypeToControlCommand
   * @exception ProcessingException
   */
  public void assignControlType(AssignControlTypeToControlCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ControlBusinessDelegate parentDelegate = ControlBusinessDelegate.getControlInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ControlType on Control
   *
   * @param command UnAssignControlTypeFromControlCommand
   * @exception ProcessingException
   */
  public void unAssignControlType(UnAssignControlTypeFromControlCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ControlType on Control";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign OperationInProgress on Control
   *
   * @param command AssignOperationInProgressToControlCommand
   * @exception ProcessingException
   */
  public void assignOperationInProgress(AssignOperationInProgressToControlCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ControlBusinessDelegate parentDelegate = ControlBusinessDelegate.getControlInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign OperationInProgress on Control
   *
   * @param command UnAssignOperationInProgressFromControlCommand
   * @exception ProcessingException
   */
  public void unAssignOperationInProgress(UnAssignOperationInProgressFromControlCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign OperationInProgress on Control";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign TimeStamp on Control
   *
   * @param command AssignTimeStampToControlCommand
   * @exception ProcessingException
   */
  public void assignTimeStamp(AssignTimeStampToControlCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateTimeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateTimeBusinessDelegate.getDateTimeInstance();
    ControlBusinessDelegate parentDelegate = ControlBusinessDelegate.getControlInstance();
    UUID childId = command.getAssignment().getDateTimeId();
    DateTime child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateTime using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign TimeStamp on Control
   *
   * @param command UnAssignTimeStampFromControlCommand
   * @exception ProcessingException
   */
  public void unAssignTimeStamp(UnAssignTimeStampFromControlCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign TimeStamp on Control";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add Control to Controls
   *
   * @param command AssignControlsToControlCommand
   * @exception ProcessingException
   */
  public void addToControls(AssignControlsToControlCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .ControlBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.ControlBusinessDelegate.getControlInstance();
    ControlBusinessDelegate parentDelegate = ControlBusinessDelegate.getControlInstance();
    UUID childId = command.getAddTo().getControlId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Control as Controls to Control";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Control from Controls
   *
   * @param command RemoveControlsFromControlCommand
   * @exception ProcessingException
   */
  public void removeFromControls(RemoveControlsFromControlCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .ControlBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.ControlBusinessDelegate.getControlInstance();
    UUID childId = command.getRemoveFrom().getControlId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlValidator.getInstance().validate(command);

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
   * @return Control
   */
  private Control load(UUID id) throws ProcessingException {
    control =
        ControlBusinessDelegate.getControlInstance().getControl(new ControlFetchOneSummary(id));
    return control;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Control control = null;
  private static final Logger LOGGER = Logger.getLogger(ControlBusinessDelegate.class.getName());
}
