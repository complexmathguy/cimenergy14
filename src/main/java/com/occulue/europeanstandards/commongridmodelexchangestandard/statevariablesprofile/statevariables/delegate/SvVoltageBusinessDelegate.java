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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.validator.*;
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
 * SvVoltage business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SvVoltage related services in the case of a SvVoltage business
 *       related service failing.
 *   <li>Exposes a simpler, uniform SvVoltage interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SvVoltage business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SvVoltageBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SvVoltageBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SvVoltage Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SvVoltageBusinessDelegate
   */
  public static SvVoltageBusinessDelegate getSvVoltageInstance() {
    return (new SvVoltageBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSvVoltage(CreateSvVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSvVoltageId() == null) command.setSvVoltageId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSvVoltageCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSvVoltageCommand of SvVoltage is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SvVoltage - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSvVoltageCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSvVoltage(UpdateSvVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSvVoltageCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SvVoltage - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSvVoltageCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSvVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSvVoltageCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SvVoltage using Id = " + command.getSvVoltageId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SvVoltage via SvVoltageFetchOneSummary
   *
   * @param summary SvVoltageFetchOneSummary
   * @return SvVoltageFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SvVoltage getSvVoltage(SvVoltageFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SvVoltageFetchOneSummary arg cannot be null");

    SvVoltage entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SvVoltage
      // --------------------------------------
      CompletableFuture<SvVoltage> futureEntity =
          queryGateway.query(
              new FindSvVoltageQuery(new LoadSvVoltageFilter(summary.getSvVoltageId())),
              ResponseTypes.instanceOf(SvVoltage.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SvVoltage with id " + summary.getSvVoltageId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SvVoltages
   *
   * @return List<SvVoltage>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SvVoltage> getAllSvVoltage() throws ProcessingException {
    List<SvVoltage> list = null;

    try {
      CompletableFuture<List<SvVoltage>> futureList =
          queryGateway.query(
              new FindAllSvVoltageQuery(), ResponseTypes.multipleInstancesOf(SvVoltage.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SvVoltage";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Angle on SvVoltage
   *
   * @param command AssignAngleToSvVoltageCommand
   * @exception ProcessingException
   */
  public void assignAngle(AssignAngleToSvVoltageCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvVoltageId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    SvVoltageBusinessDelegate parentDelegate = SvVoltageBusinessDelegate.getSvVoltageInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Angle on SvVoltage
   *
   * @param command UnAssignAngleFromSvVoltageCommand
   * @exception ProcessingException
   */
  public void unAssignAngle(UnAssignAngleFromSvVoltageCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Angle on SvVoltage";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign V on SvVoltage
   *
   * @param command AssignVToSvVoltageCommand
   * @exception ProcessingException
   */
  public void assignV(AssignVToSvVoltageCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvVoltageId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    SvVoltageBusinessDelegate parentDelegate = SvVoltageBusinessDelegate.getSvVoltageInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign V on SvVoltage
   *
   * @param command UnAssignVFromSvVoltageCommand
   * @exception ProcessingException
   */
  public void unAssignV(UnAssignVFromSvVoltageCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign V on SvVoltage";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SvVoltage on SvVoltage
   *
   * @param command AssignSvVoltageToSvVoltageCommand
   * @exception ProcessingException
   */
  public void assignSvVoltage(AssignSvVoltageToSvVoltageCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvVoltageId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
            .statevariables.delegate.SvVoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
                .statevariables.delegate.SvVoltageBusinessDelegate.getSvVoltageInstance();
    SvVoltageBusinessDelegate parentDelegate = SvVoltageBusinessDelegate.getSvVoltageInstance();
    UUID childId = command.getAssignment().getSvVoltageId();
    SvVoltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get SvVoltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SvVoltage on SvVoltage
   *
   * @param command UnAssignSvVoltageFromSvVoltageCommand
   * @exception ProcessingException
   */
  public void unAssignSvVoltage(UnAssignSvVoltageFromSvVoltageCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SvVoltage on SvVoltage";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SvVoltage
   */
  private SvVoltage load(UUID id) throws ProcessingException {
    svVoltage =
        SvVoltageBusinessDelegate.getSvVoltageInstance()
            .getSvVoltage(new SvVoltageFetchOneSummary(id));
    return svVoltage;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SvVoltage svVoltage = null;
  private static final Logger LOGGER = Logger.getLogger(SvVoltageBusinessDelegate.class.getName());
}
