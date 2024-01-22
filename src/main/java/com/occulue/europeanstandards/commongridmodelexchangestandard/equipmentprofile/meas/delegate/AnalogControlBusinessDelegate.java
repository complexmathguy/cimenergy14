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
 * AnalogControl business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AnalogControl related services in the case of a AnalogControl
 *       business related service failing.
 *   <li>Exposes a simpler, uniform AnalogControl interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill AnalogControl business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AnalogControlBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AnalogControlBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AnalogControl Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AnalogControlBusinessDelegate
   */
  public static AnalogControlBusinessDelegate getAnalogControlInstance() {
    return (new AnalogControlBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAnalogControl(CreateAnalogControlCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAnalogControlId() == null) command.setAnalogControlId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAnalogControlCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAnalogControlCommand of AnalogControl is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AnalogControl - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAnalogControlCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAnalogControl(UpdateAnalogControlCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAnalogControlCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AnalogControl - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAnalogControlCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAnalogControlCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAnalogControlCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AnalogControl using Id = " + command.getAnalogControlId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AnalogControl via AnalogControlFetchOneSummary
   *
   * @param summary AnalogControlFetchOneSummary
   * @return AnalogControlFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AnalogControl getAnalogControl(AnalogControlFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AnalogControlFetchOneSummary arg cannot be null");

    AnalogControl entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AnalogControl
      // --------------------------------------
      CompletableFuture<AnalogControl> futureEntity =
          queryGateway.query(
              new FindAnalogControlQuery(new LoadAnalogControlFilter(summary.getAnalogControlId())),
              ResponseTypes.instanceOf(AnalogControl.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate AnalogControl with id " + summary.getAnalogControlId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AnalogControls
   *
   * @return List<AnalogControl>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AnalogControl> getAllAnalogControl() throws ProcessingException {
    List<AnalogControl> list = null;

    try {
      CompletableFuture<List<AnalogControl>> futureList =
          queryGateway.query(
              new FindAllAnalogControlQuery(),
              ResponseTypes.multipleInstancesOf(AnalogControl.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AnalogControl";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign MaxValue on AnalogControl
   *
   * @param command AssignMaxValueToAnalogControlCommand
   * @exception ProcessingException
   */
  public void assignMaxValue(AssignMaxValueToAnalogControlCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAnalogControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    AnalogControlBusinessDelegate parentDelegate =
        AnalogControlBusinessDelegate.getAnalogControlInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxValue on AnalogControl
   *
   * @param command UnAssignMaxValueFromAnalogControlCommand
   * @exception ProcessingException
   */
  public void unAssignMaxValue(UnAssignMaxValueFromAnalogControlCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxValue on AnalogControl";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinValue on AnalogControl
   *
   * @param command AssignMinValueToAnalogControlCommand
   * @exception ProcessingException
   */
  public void assignMinValue(AssignMinValueToAnalogControlCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAnalogControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    AnalogControlBusinessDelegate parentDelegate =
        AnalogControlBusinessDelegate.getAnalogControlInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinValue on AnalogControl
   *
   * @param command UnAssignMinValueFromAnalogControlCommand
   * @exception ProcessingException
   */
  public void unAssignMinValue(UnAssignMinValueFromAnalogControlCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinValue on AnalogControl";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign AnalogControl on AnalogControl
   *
   * @param command AssignAnalogControlToAnalogControlCommand
   * @exception ProcessingException
   */
  public void assignAnalogControl(AssignAnalogControlToAnalogControlCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAnalogControlId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AnalogControlBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AnalogControlBusinessDelegate.getAnalogControlInstance();
    AnalogControlBusinessDelegate parentDelegate =
        AnalogControlBusinessDelegate.getAnalogControlInstance();
    UUID childId = command.getAssignment().getAnalogControlId();
    AnalogControl child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AnalogControl using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign AnalogControl on AnalogControl
   *
   * @param command UnAssignAnalogControlFromAnalogControlCommand
   * @exception ProcessingException
   */
  public void unAssignAnalogControl(UnAssignAnalogControlFromAnalogControlCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogControlValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign AnalogControl on AnalogControl";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return AnalogControl
   */
  private AnalogControl load(UUID id) throws ProcessingException {
    analogControl =
        AnalogControlBusinessDelegate.getAnalogControlInstance()
            .getAnalogControl(new AnalogControlFetchOneSummary(id));
    return analogControl;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AnalogControl analogControl = null;
  private static final Logger LOGGER =
      Logger.getLogger(AnalogControlBusinessDelegate.class.getName());
}
