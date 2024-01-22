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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * RegulatingControl business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RegulatingControl related services in the case of a
 *       RegulatingControl business related service failing.
 *   <li>Exposes a simpler, uniform RegulatingControl interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RegulatingControl business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RegulatingControlBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RegulatingControlBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RegulatingControl Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RegulatingControlBusinessDelegate
   */
  public static RegulatingControlBusinessDelegate getRegulatingControlInstance() {
    return (new RegulatingControlBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRegulatingControl(CreateRegulatingControlCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRegulatingControlId() == null)
        command.setRegulatingControlId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingControlValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRegulatingControlCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRegulatingControlCommand of RegulatingControl is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RegulatingControl - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRegulatingControlCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRegulatingControl(UpdateRegulatingControlCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RegulatingControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRegulatingControlCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RegulatingControl - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRegulatingControlCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRegulatingControlCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRegulatingControlCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RegulatingControl using Id = " + command.getRegulatingControlId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RegulatingControl via RegulatingControlFetchOneSummary
   *
   * @param summary RegulatingControlFetchOneSummary
   * @return RegulatingControlFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RegulatingControl getRegulatingControl(RegulatingControlFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("RegulatingControlFetchOneSummary arg cannot be null");

    RegulatingControl entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RegulatingControlValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RegulatingControl
      // --------------------------------------
      CompletableFuture<RegulatingControl> futureEntity =
          queryGateway.query(
              new FindRegulatingControlQuery(
                  new LoadRegulatingControlFilter(summary.getRegulatingControlId())),
              ResponseTypes.instanceOf(RegulatingControl.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RegulatingControl with id " + summary.getRegulatingControlId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RegulatingControls
   *
   * @return List<RegulatingControl>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RegulatingControl> getAllRegulatingControl() throws ProcessingException {
    List<RegulatingControl> list = null;

    try {
      CompletableFuture<List<RegulatingControl>> futureList =
          queryGateway.query(
              new FindAllRegulatingControlQuery(),
              ResponseTypes.multipleInstancesOf(RegulatingControl.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RegulatingControl";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign RegulatingControl on RegulatingControl
   *
   * @param command AssignRegulatingControlToRegulatingControlCommand
   * @exception ProcessingException
   */
  public void assignRegulatingControl(AssignRegulatingControlToRegulatingControlCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRegulatingControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RegulatingControlBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RegulatingControlBusinessDelegate.getRegulatingControlInstance();
    RegulatingControlBusinessDelegate parentDelegate =
        RegulatingControlBusinessDelegate.getRegulatingControlInstance();
    UUID childId = command.getAssignment().getRegulatingControlId();
    RegulatingControl child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RegulatingControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get RegulatingControl using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RegulatingControl on RegulatingControl
   *
   * @param command UnAssignRegulatingControlFromRegulatingControlCommand
   * @exception ProcessingException
   */
  public void unAssignRegulatingControl(
      UnAssignRegulatingControlFromRegulatingControlCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RegulatingControl on RegulatingControl";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return RegulatingControl
   */
  private RegulatingControl load(UUID id) throws ProcessingException {
    regulatingControl =
        RegulatingControlBusinessDelegate.getRegulatingControlInstance()
            .getRegulatingControl(new RegulatingControlFetchOneSummary(id));
    return regulatingControl;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RegulatingControl regulatingControl = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegulatingControlBusinessDelegate.class.getName());
}
