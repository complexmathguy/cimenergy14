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
 * GovHydroIEEE0 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovHydroIEEE0 related services in the case of a GovHydroIEEE0
 *       business related service failing.
 *   <li>Exposes a simpler, uniform GovHydroIEEE0 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovHydroIEEE0 business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovHydroIEEE0BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovHydroIEEE0BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovHydroIEEE0 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovHydroIEEE0BusinessDelegate
   */
  public static GovHydroIEEE0BusinessDelegate getGovHydroIEEE0Instance() {
    return (new GovHydroIEEE0BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovHydroIEEE0(CreateGovHydroIEEE0Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovHydroIEEE0Id() == null) command.setGovHydroIEEE0Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovHydroIEEE0Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovHydroIEEE0Command of GovHydroIEEE0 is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovHydroIEEE0 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovHydroIEEE0Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovHydroIEEE0(UpdateGovHydroIEEE0Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovHydroIEEE0Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovHydroIEEE0 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovHydroIEEE0Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovHydroIEEE0Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovHydroIEEE0Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GovHydroIEEE0 using Id = " + command.getGovHydroIEEE0Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovHydroIEEE0 via GovHydroIEEE0FetchOneSummary
   *
   * @param summary GovHydroIEEE0FetchOneSummary
   * @return GovHydroIEEE0FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovHydroIEEE0 getGovHydroIEEE0(GovHydroIEEE0FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovHydroIEEE0FetchOneSummary arg cannot be null");

    GovHydroIEEE0 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovHydroIEEE0
      // --------------------------------------
      CompletableFuture<GovHydroIEEE0> futureEntity =
          queryGateway.query(
              new FindGovHydroIEEE0Query(new LoadGovHydroIEEE0Filter(summary.getGovHydroIEEE0Id())),
              ResponseTypes.instanceOf(GovHydroIEEE0.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GovHydroIEEE0 with id " + summary.getGovHydroIEEE0Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovHydroIEEE0s
   *
   * @return List<GovHydroIEEE0>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovHydroIEEE0> getAllGovHydroIEEE0() throws ProcessingException {
    List<GovHydroIEEE0> list = null;

    try {
      CompletableFuture<List<GovHydroIEEE0>> futureList =
          queryGateway.query(
              new FindAllGovHydroIEEE0Query(),
              ResponseTypes.multipleInstancesOf(GovHydroIEEE0.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovHydroIEEE0";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign K on GovHydroIEEE0
   *
   * @param command AssignKToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignK(AssignKToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign K on GovHydroIEEE0
   *
   * @param command UnAssignKFromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignK(UnAssignKFromGovHydroIEEE0Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwbase on GovHydroIEEE0
   *
   * @param command AssignMwbaseToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignMwbase(AssignMwbaseToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign Mwbase on GovHydroIEEE0
   *
   * @param command UnAssignMwbaseFromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignMwbase(UnAssignMwbaseFromGovHydroIEEE0Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwbase on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmax on GovHydroIEEE0
   *
   * @param command AssignPmaxToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignPmax(AssignPmaxToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign Pmax on GovHydroIEEE0
   *
   * @param command UnAssignPmaxFromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignPmax(UnAssignPmaxFromGovHydroIEEE0Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmax on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmin on GovHydroIEEE0
   *
   * @param command AssignPminToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignPmin(AssignPminToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign Pmin on GovHydroIEEE0
   *
   * @param command UnAssignPminFromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignPmin(UnAssignPminFromGovHydroIEEE0Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmin on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on GovHydroIEEE0
   *
   * @param command AssignT1ToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign T1 on GovHydroIEEE0
   *
   * @param command UnAssignT1FromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromGovHydroIEEE0Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on GovHydroIEEE0
   *
   * @param command AssignT2ToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign T2 on GovHydroIEEE0
   *
   * @param command UnAssignT2FromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromGovHydroIEEE0Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T3 on GovHydroIEEE0
   *
   * @param command AssignT3ToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignT3(AssignT3ToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign T3 on GovHydroIEEE0
   *
   * @param command UnAssignT3FromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignT3(UnAssignT3FromGovHydroIEEE0Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T3 on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T4 on GovHydroIEEE0
   *
   * @param command AssignT4ToGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void assignT4(AssignT4ToGovHydroIEEE0Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroIEEE0Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroIEEE0BusinessDelegate parentDelegate =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

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
   * unAssign T4 on GovHydroIEEE0
   *
   * @param command UnAssignT4FromGovHydroIEEE0Command
   * @exception ProcessingException
   */
  public void unAssignT4(UnAssignT4FromGovHydroIEEE0Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroIEEE0Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T4 on GovHydroIEEE0";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovHydroIEEE0
   */
  private GovHydroIEEE0 load(UUID id) throws ProcessingException {
    govHydroIEEE0 =
        GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance()
            .getGovHydroIEEE0(new GovHydroIEEE0FetchOneSummary(id));
    return govHydroIEEE0;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovHydroIEEE0 govHydroIEEE0 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroIEEE0BusinessDelegate.class.getName());
}
