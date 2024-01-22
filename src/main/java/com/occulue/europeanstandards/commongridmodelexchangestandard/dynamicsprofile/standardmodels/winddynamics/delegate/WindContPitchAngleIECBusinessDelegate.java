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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindContPitchAngleIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindContPitchAngleIEC related services in the case of a
 *       WindContPitchAngleIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindContPitchAngleIEC interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindContPitchAngleIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindContPitchAngleIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindContPitchAngleIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindContPitchAngleIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindContPitchAngleIECBusinessDelegate
   */
  public static WindContPitchAngleIECBusinessDelegate getWindContPitchAngleIECInstance() {
    return (new WindContPitchAngleIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindContPitchAngleIEC(
      CreateWindContPitchAngleIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindContPitchAngleIECId() == null)
        command.setWindContPitchAngleIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindContPitchAngleIECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindContPitchAngleIECCommand of WindContPitchAngleIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindContPitchAngleIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindContPitchAngleIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindContPitchAngleIEC(
      UpdateWindContPitchAngleIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindContPitchAngleIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindContPitchAngleIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindContPitchAngleIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindContPitchAngleIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindContPitchAngleIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindContPitchAngleIEC using Id = "
              + command.getWindContPitchAngleIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindContPitchAngleIEC via WindContPitchAngleIECFetchOneSummary
   *
   * @param summary WindContPitchAngleIECFetchOneSummary
   * @return WindContPitchAngleIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindContPitchAngleIEC getWindContPitchAngleIEC(
      WindContPitchAngleIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindContPitchAngleIECFetchOneSummary arg cannot be null");

    WindContPitchAngleIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindContPitchAngleIEC
      // --------------------------------------
      CompletableFuture<WindContPitchAngleIEC> futureEntity =
          queryGateway.query(
              new FindWindContPitchAngleIECQuery(
                  new LoadWindContPitchAngleIECFilter(summary.getWindContPitchAngleIECId())),
              ResponseTypes.instanceOf(WindContPitchAngleIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindContPitchAngleIEC with id " + summary.getWindContPitchAngleIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindContPitchAngleIECs
   *
   * @return List<WindContPitchAngleIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindContPitchAngleIEC> getAllWindContPitchAngleIEC() throws ProcessingException {
    List<WindContPitchAngleIEC> list = null;

    try {
      CompletableFuture<List<WindContPitchAngleIEC>> futureList =
          queryGateway.query(
              new FindAllWindContPitchAngleIECQuery(),
              ResponseTypes.multipleInstancesOf(WindContPitchAngleIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Dthetamax on WindContPitchAngleIEC
   *
   * @param command AssignDthetamaxToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignDthetamax(AssignDthetamaxToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

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
   * unAssign Dthetamax on WindContPitchAngleIEC
   *
   * @param command UnAssignDthetamaxFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignDthetamax(UnAssignDthetamaxFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dthetamax on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dthetamin on WindContPitchAngleIEC
   *
   * @param command AssignDthetaminToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignDthetamin(AssignDthetaminToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

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
   * unAssign Dthetamin on WindContPitchAngleIEC
   *
   * @param command UnAssignDthetaminFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignDthetamin(UnAssignDthetaminFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dthetamin on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kic on WindContPitchAngleIEC
   *
   * @param command AssignKicToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignKic(AssignKicToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kic on WindContPitchAngleIEC
   *
   * @param command UnAssignKicFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignKic(UnAssignKicFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kic on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kiomega on WindContPitchAngleIEC
   *
   * @param command AssignKiomegaToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignKiomega(AssignKiomegaToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kiomega on WindContPitchAngleIEC
   *
   * @param command UnAssignKiomegaFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignKiomega(UnAssignKiomegaFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kiomega on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpc on WindContPitchAngleIEC
   *
   * @param command AssignKpcToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignKpc(AssignKpcToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kpc on WindContPitchAngleIEC
   *
   * @param command UnAssignKpcFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpc(UnAssignKpcFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpc on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpomega on WindContPitchAngleIEC
   *
   * @param command AssignKpomegaToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignKpomega(AssignKpomegaToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kpomega on WindContPitchAngleIEC
   *
   * @param command UnAssignKpomegaFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpomega(UnAssignKpomegaFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpomega on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpx on WindContPitchAngleIEC
   *
   * @param command AssignKpxToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignKpx(AssignKpxToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kpx on WindContPitchAngleIEC
   *
   * @param command UnAssignKpxFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpx(UnAssignKpxFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpx on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Thetamax on WindContPitchAngleIEC
   *
   * @param command AssignThetamaxToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignThetamax(AssignThetamaxToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

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
   * unAssign Thetamax on WindContPitchAngleIEC
   *
   * @param command UnAssignThetamaxFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignThetamax(UnAssignThetamaxFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Thetamax on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Thetamin on WindContPitchAngleIEC
   *
   * @param command AssignThetaminToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignThetamin(AssignThetaminToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

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
   * unAssign Thetamin on WindContPitchAngleIEC
   *
   * @param command UnAssignThetaminFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignThetamin(UnAssignThetaminFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Thetamin on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ttheta on WindContPitchAngleIEC
   *
   * @param command AssignTthetaToWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void assignTtheta(AssignTthetaToWindContPitchAngleIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPitchAngleIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContPitchAngleIECBusinessDelegate parentDelegate =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ttheta on WindContPitchAngleIEC
   *
   * @param command UnAssignTthetaFromWindContPitchAngleIECCommand
   * @exception ProcessingException
   */
  public void unAssignTtheta(UnAssignTthetaFromWindContPitchAngleIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPitchAngleIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ttheta on WindContPitchAngleIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindContPitchAngleIEC
   */
  private WindContPitchAngleIEC load(UUID id) throws ProcessingException {
    windContPitchAngleIEC =
        WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
            .getWindContPitchAngleIEC(new WindContPitchAngleIECFetchOneSummary(id));
    return windContPitchAngleIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindContPitchAngleIEC windContPitchAngleIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPitchAngleIECBusinessDelegate.class.getName());
}
