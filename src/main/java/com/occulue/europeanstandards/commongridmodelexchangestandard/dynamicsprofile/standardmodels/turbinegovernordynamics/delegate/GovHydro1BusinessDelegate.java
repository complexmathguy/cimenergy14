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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.validator.*;
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
 * GovHydro1 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovHydro1 related services in the case of a GovHydro1 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform GovHydro1 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovHydro1 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovHydro1BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovHydro1BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovHydro1 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovHydro1BusinessDelegate
   */
  public static GovHydro1BusinessDelegate getGovHydro1Instance() {
    return (new GovHydro1BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovHydro1(CreateGovHydro1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovHydro1Id() == null) command.setGovHydro1Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovHydro1Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovHydro1Command of GovHydro1 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovHydro1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovHydro1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovHydro1(UpdateGovHydro1Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovHydro1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovHydro1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovHydro1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovHydro1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovHydro1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete GovHydro1 using Id = " + command.getGovHydro1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovHydro1 via GovHydro1FetchOneSummary
   *
   * @param summary GovHydro1FetchOneSummary
   * @return GovHydro1FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovHydro1 getGovHydro1(GovHydro1FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovHydro1FetchOneSummary arg cannot be null");

    GovHydro1 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovHydro1
      // --------------------------------------
      CompletableFuture<GovHydro1> futureEntity =
          queryGateway.query(
              new FindGovHydro1Query(new LoadGovHydro1Filter(summary.getGovHydro1Id())),
              ResponseTypes.instanceOf(GovHydro1.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate GovHydro1 with id " + summary.getGovHydro1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovHydro1s
   *
   * @return List<GovHydro1>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovHydro1> getAllGovHydro1() throws ProcessingException {
    List<GovHydro1> list = null;

    try {
      CompletableFuture<List<GovHydro1>> futureList =
          queryGateway.query(
              new FindAllGovHydro1Query(), ResponseTypes.multipleInstancesOf(GovHydro1.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovHydro1";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign At on GovHydro1
   *
   * @param command AssignAtToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignAt(AssignAtToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign At on GovHydro1
   *
   * @param command UnAssignAtFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignAt(UnAssignAtFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign At on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dturb on GovHydro1
   *
   * @param command AssignDturbToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignDturb(AssignDturbToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Dturb on GovHydro1
   *
   * @param command UnAssignDturbFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignDturb(UnAssignDturbFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dturb on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gmax on GovHydro1
   *
   * @param command AssignGmaxToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignGmax(AssignGmaxToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Gmax on GovHydro1
   *
   * @param command UnAssignGmaxFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignGmax(UnAssignGmaxFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gmax on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gmin on GovHydro1
   *
   * @param command AssignGminToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignGmin(AssignGminToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Gmin on GovHydro1
   *
   * @param command UnAssignGminFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignGmin(UnAssignGminFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gmin on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Hdam on GovHydro1
   *
   * @param command AssignHdamToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignHdam(AssignHdamToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Hdam on GovHydro1
   *
   * @param command UnAssignHdamFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignHdam(UnAssignHdamFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Hdam on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwbase on GovHydro1
   *
   * @param command AssignMwbaseToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignMwbase(AssignMwbaseToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Mwbase on GovHydro1
   *
   * @param command UnAssignMwbaseFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignMwbase(UnAssignMwbaseFromGovHydro1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwbase on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qnl on GovHydro1
   *
   * @param command AssignQnlToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignQnl(AssignQnlToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Qnl on GovHydro1
   *
   * @param command UnAssignQnlFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignQnl(UnAssignQnlFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qnl on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rperm on GovHydro1
   *
   * @param command AssignRpermToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignRperm(AssignRpermToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Rperm on GovHydro1
   *
   * @param command UnAssignRpermFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignRperm(UnAssignRpermFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rperm on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rtemp on GovHydro1
   *
   * @param command AssignRtempToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignRtemp(AssignRtempToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Rtemp on GovHydro1
   *
   * @param command UnAssignRtempFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignRtemp(UnAssignRtempFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rtemp on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on GovHydro1
   *
   * @param command AssignTfToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Tf on GovHydro1
   *
   * @param command UnAssignTfFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tg on GovHydro1
   *
   * @param command AssignTgToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignTg(AssignTgToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Tg on GovHydro1
   *
   * @param command UnAssignTgFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignTg(UnAssignTgFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tg on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tr on GovHydro1
   *
   * @param command AssignTrToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignTr(AssignTrToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Tr on GovHydro1
   *
   * @param command UnAssignTrFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignTr(UnAssignTrFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tr on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw on GovHydro1
   *
   * @param command AssignTwToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignTw(AssignTwToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Tw on GovHydro1
   *
   * @param command UnAssignTwFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignTw(UnAssignTwFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Velm on GovHydro1
   *
   * @param command AssignVelmToGovHydro1Command
   * @exception ProcessingException
   */
  public void assignVelm(AssignVelmToGovHydro1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydro1BusinessDelegate parentDelegate = GovHydro1BusinessDelegate.getGovHydro1Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

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
   * unAssign Velm on GovHydro1
   *
   * @param command UnAssignVelmFromGovHydro1Command
   * @exception ProcessingException
   */
  public void unAssignVelm(UnAssignVelmFromGovHydro1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Velm on GovHydro1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovHydro1
   */
  private GovHydro1 load(UUID id) throws ProcessingException {
    govHydro1 =
        GovHydro1BusinessDelegate.getGovHydro1Instance()
            .getGovHydro1(new GovHydro1FetchOneSummary(id));
    return govHydro1;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovHydro1 govHydro1 = null;
  private static final Logger LOGGER = Logger.getLogger(GovHydro1BusinessDelegate.class.getName());
}
