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
 * GovHydro3 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovHydro3 related services in the case of a GovHydro3 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform GovHydro3 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovHydro3 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovHydro3BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovHydro3BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovHydro3 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovHydro3BusinessDelegate
   */
  public static GovHydro3BusinessDelegate getGovHydro3Instance() {
    return (new GovHydro3BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovHydro3(CreateGovHydro3Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovHydro3Id() == null) command.setGovHydro3Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovHydro3Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovHydro3Command of GovHydro3 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovHydro3 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovHydro3Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovHydro3(UpdateGovHydro3Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovHydro3Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovHydro3 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovHydro3Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovHydro3Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovHydro3Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete GovHydro3 using Id = " + command.getGovHydro3Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovHydro3 via GovHydro3FetchOneSummary
   *
   * @param summary GovHydro3FetchOneSummary
   * @return GovHydro3FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovHydro3 getGovHydro3(GovHydro3FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovHydro3FetchOneSummary arg cannot be null");

    GovHydro3 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovHydro3
      // --------------------------------------
      CompletableFuture<GovHydro3> futureEntity =
          queryGateway.query(
              new FindGovHydro3Query(new LoadGovHydro3Filter(summary.getGovHydro3Id())),
              ResponseTypes.instanceOf(GovHydro3.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate GovHydro3 with id " + summary.getGovHydro3Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovHydro3s
   *
   * @return List<GovHydro3>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovHydro3> getAllGovHydro3() throws ProcessingException {
    List<GovHydro3> list = null;

    try {
      CompletableFuture<List<GovHydro3>> futureList =
          queryGateway.query(
              new FindAllGovHydro3Query(), ResponseTypes.multipleInstancesOf(GovHydro3.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovHydro3";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign At on GovHydro3
   *
   * @param command AssignAtToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignAt(AssignAtToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign At on GovHydro3
   *
   * @param command UnAssignAtFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignAt(UnAssignAtFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign At on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db1 on GovHydro3
   *
   * @param command AssignDb1ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignDb1(AssignDb1ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Frequency using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Db1 on GovHydro3
   *
   * @param command UnAssignDb1FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignDb1(UnAssignDb1FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db1 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db2 on GovHydro3
   *
   * @param command AssignDb2ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignDb2(AssignDb2ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Db2 on GovHydro3
   *
   * @param command UnAssignDb2FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignDb2(UnAssignDb2FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db2 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dturb on GovHydro3
   *
   * @param command AssignDturbToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignDturb(AssignDturbToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Dturb on GovHydro3
   *
   * @param command UnAssignDturbFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignDturb(UnAssignDturbFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dturb on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Eps on GovHydro3
   *
   * @param command AssignEpsToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignEps(AssignEpsToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Frequency using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Eps on GovHydro3
   *
   * @param command UnAssignEpsFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignEps(UnAssignEpsFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Eps on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign GovernorControl on GovHydro3
   *
   * @param command AssignGovernorControlToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGovernorControl(AssignGovernorControlToGovHydro3Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign GovernorControl on GovHydro3
   *
   * @param command UnAssignGovernorControlFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGovernorControl(UnAssignGovernorControlFromGovHydro3Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign GovernorControl on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv1 on GovHydro3
   *
   * @param command AssignGv1ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGv1(AssignGv1ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Gv1 on GovHydro3
   *
   * @param command UnAssignGv1FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGv1(UnAssignGv1FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv1 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv2 on GovHydro3
   *
   * @param command AssignGv2ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGv2(AssignGv2ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Gv2 on GovHydro3
   *
   * @param command UnAssignGv2FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGv2(UnAssignGv2FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv2 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv3 on GovHydro3
   *
   * @param command AssignGv3ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGv3(AssignGv3ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Gv3 on GovHydro3
   *
   * @param command UnAssignGv3FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGv3(UnAssignGv3FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv3 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv4 on GovHydro3
   *
   * @param command AssignGv4ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGv4(AssignGv4ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Gv4 on GovHydro3
   *
   * @param command UnAssignGv4FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGv4(UnAssignGv4FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv4 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv5 on GovHydro3
   *
   * @param command AssignGv5ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGv5(AssignGv5ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Gv5 on GovHydro3
   *
   * @param command UnAssignGv5FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGv5(UnAssignGv5FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv5 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv6 on GovHydro3
   *
   * @param command AssignGv6ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignGv6(AssignGv6ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Gv6 on GovHydro3
   *
   * @param command UnAssignGv6FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignGv6(UnAssignGv6FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv6 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign H0 on GovHydro3
   *
   * @param command AssignH0ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignH0(AssignH0ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign H0 on GovHydro3
   *
   * @param command UnAssignH0FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignH0(UnAssignH0FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign H0 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign K1 on GovHydro3
   *
   * @param command AssignK1ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignK1(AssignK1ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign K1 on GovHydro3
   *
   * @param command UnAssignK1FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignK1(UnAssignK1FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K1 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign K2 on GovHydro3
   *
   * @param command AssignK2ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignK2(AssignK2ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign K2 on GovHydro3
   *
   * @param command UnAssignK2FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignK2(UnAssignK2FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K2 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kg on GovHydro3
   *
   * @param command AssignKgToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignKg(AssignKgToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Kg on GovHydro3
   *
   * @param command UnAssignKgFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignKg(UnAssignKgFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kg on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ki on GovHydro3
   *
   * @param command AssignKiToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignKi(AssignKiToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Ki on GovHydro3
   *
   * @param command UnAssignKiFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignKi(UnAssignKiFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ki on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwbase on GovHydro3
   *
   * @param command AssignMwbaseToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignMwbase(AssignMwbaseToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Mwbase on GovHydro3
   *
   * @param command UnAssignMwbaseFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignMwbase(UnAssignMwbaseFromGovHydro3Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwbase on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv1 on GovHydro3
   *
   * @param command AssignPgv1ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPgv1(AssignPgv1ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pgv1 on GovHydro3
   *
   * @param command UnAssignPgv1FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPgv1(UnAssignPgv1FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv1 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv2 on GovHydro3
   *
   * @param command AssignPgv2ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPgv2(AssignPgv2ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pgv2 on GovHydro3
   *
   * @param command UnAssignPgv2FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPgv2(UnAssignPgv2FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv2 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv3 on GovHydro3
   *
   * @param command AssignPgv3ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPgv3(AssignPgv3ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pgv3 on GovHydro3
   *
   * @param command UnAssignPgv3FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPgv3(UnAssignPgv3FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv3 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv4 on GovHydro3
   *
   * @param command AssignPgv4ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPgv4(AssignPgv4ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pgv4 on GovHydro3
   *
   * @param command UnAssignPgv4FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPgv4(UnAssignPgv4FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv4 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv5 on GovHydro3
   *
   * @param command AssignPgv5ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPgv5(AssignPgv5ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pgv5 on GovHydro3
   *
   * @param command UnAssignPgv5FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPgv5(UnAssignPgv5FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv5 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv6 on GovHydro3
   *
   * @param command AssignPgv6ToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPgv6(AssignPgv6ToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pgv6 on GovHydro3
   *
   * @param command UnAssignPgv6FromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPgv6(UnAssignPgv6FromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv6 on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmax on GovHydro3
   *
   * @param command AssignPmaxToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPmax(AssignPmaxToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pmax on GovHydro3
   *
   * @param command UnAssignPmaxFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPmax(UnAssignPmaxFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmax on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmin on GovHydro3
   *
   * @param command AssignPminToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignPmin(AssignPminToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Pmin on GovHydro3
   *
   * @param command UnAssignPminFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignPmin(UnAssignPminFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmin on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qnl on GovHydro3
   *
   * @param command AssignQnlToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignQnl(AssignQnlToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Qnl on GovHydro3
   *
   * @param command UnAssignQnlFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignQnl(UnAssignQnlFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qnl on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Relec on GovHydro3
   *
   * @param command AssignRelecToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignRelec(AssignRelecToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Relec on GovHydro3
   *
   * @param command UnAssignRelecFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignRelec(UnAssignRelecFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Relec on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rgate on GovHydro3
   *
   * @param command AssignRgateToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignRgate(AssignRgateToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Rgate on GovHydro3
   *
   * @param command UnAssignRgateFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignRgate(UnAssignRgateFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rgate on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Td on GovHydro3
   *
   * @param command AssignTdToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignTd(AssignTdToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Td on GovHydro3
   *
   * @param command UnAssignTdFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignTd(UnAssignTdFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Td on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on GovHydro3
   *
   * @param command AssignTfToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Tf on GovHydro3
   *
   * @param command UnAssignTfFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tp on GovHydro3
   *
   * @param command AssignTpToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignTp(AssignTpToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Tp on GovHydro3
   *
   * @param command UnAssignTpFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignTp(UnAssignTpFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tp on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tt on GovHydro3
   *
   * @param command AssignTtToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignTt(AssignTtToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Tt on GovHydro3
   *
   * @param command UnAssignTtFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignTt(UnAssignTtFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tt on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw on GovHydro3
   *
   * @param command AssignTwToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignTw(AssignTwToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Tw on GovHydro3
   *
   * @param command UnAssignTwFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignTw(UnAssignTwFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Velcl on GovHydro3
   *
   * @param command AssignVelclToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignVelcl(AssignVelclToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Velcl on GovHydro3
   *
   * @param command UnAssignVelclFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignVelcl(UnAssignVelclFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Velcl on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Velop on GovHydro3
   *
   * @param command AssignVelopToGovHydro3Command
   * @exception ProcessingException
   */
  public void assignVelop(AssignVelopToGovHydro3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydro3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydro3BusinessDelegate parentDelegate = GovHydro3BusinessDelegate.getGovHydro3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

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
   * unAssign Velop on GovHydro3
   *
   * @param command UnAssignVelopFromGovHydro3Command
   * @exception ProcessingException
   */
  public void unAssignVelop(UnAssignVelopFromGovHydro3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydro3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Velop on GovHydro3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovHydro3
   */
  private GovHydro3 load(UUID id) throws ProcessingException {
    govHydro3 =
        GovHydro3BusinessDelegate.getGovHydro3Instance()
            .getGovHydro3(new GovHydro3FetchOneSummary(id));
    return govHydro3;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovHydro3 govHydro3 = null;
  private static final Logger LOGGER = Logger.getLogger(GovHydro3BusinessDelegate.class.getName());
}
