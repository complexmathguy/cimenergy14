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
 * GovHydroPID business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovHydroPID related services in the case of a GovHydroPID
 *       business related service failing.
 *   <li>Exposes a simpler, uniform GovHydroPID interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovHydroPID business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovHydroPIDBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovHydroPIDBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovHydroPID Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovHydroPIDBusinessDelegate
   */
  public static GovHydroPIDBusinessDelegate getGovHydroPIDInstance() {
    return (new GovHydroPIDBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovHydroPID(CreateGovHydroPIDCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovHydroPIDId() == null) command.setGovHydroPIDId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovHydroPIDCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovHydroPIDCommand of GovHydroPID is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovHydroPID - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovHydroPIDCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovHydroPID(UpdateGovHydroPIDCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovHydroPIDCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovHydroPID - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovHydroPIDCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovHydroPIDCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovHydroPIDCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete GovHydroPID using Id = " + command.getGovHydroPIDId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovHydroPID via GovHydroPIDFetchOneSummary
   *
   * @param summary GovHydroPIDFetchOneSummary
   * @return GovHydroPIDFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovHydroPID getGovHydroPID(GovHydroPIDFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovHydroPIDFetchOneSummary arg cannot be null");

    GovHydroPID entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovHydroPID
      // --------------------------------------
      CompletableFuture<GovHydroPID> futureEntity =
          queryGateway.query(
              new FindGovHydroPIDQuery(new LoadGovHydroPIDFilter(summary.getGovHydroPIDId())),
              ResponseTypes.instanceOf(GovHydroPID.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate GovHydroPID with id " + summary.getGovHydroPIDId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovHydroPIDs
   *
   * @return List<GovHydroPID>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovHydroPID> getAllGovHydroPID() throws ProcessingException {
    List<GovHydroPID> list = null;

    try {
      CompletableFuture<List<GovHydroPID>> futureList =
          queryGateway.query(
              new FindAllGovHydroPIDQuery(), ResponseTypes.multipleInstancesOf(GovHydroPID.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovHydroPID";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Aturb on GovHydroPID
   *
   * @param command AssignAturbToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignAturb(AssignAturbToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Aturb on GovHydroPID
   *
   * @param command UnAssignAturbFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignAturb(UnAssignAturbFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Aturb on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Bturb on GovHydroPID
   *
   * @param command AssignBturbToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignBturb(AssignBturbToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Bturb on GovHydroPID
   *
   * @param command UnAssignBturbFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignBturb(UnAssignBturbFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Bturb on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db1 on GovHydroPID
   *
   * @param command AssignDb1ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignDb1(AssignDb1ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Db1 on GovHydroPID
   *
   * @param command UnAssignDb1FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignDb1(UnAssignDb1FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db1 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db2 on GovHydroPID
   *
   * @param command AssignDb2ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignDb2(AssignDb2ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Db2 on GovHydroPID
   *
   * @param command UnAssignDb2FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignDb2(UnAssignDb2FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db2 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Eps on GovHydroPID
   *
   * @param command AssignEpsToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignEps(AssignEpsToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Eps on GovHydroPID
   *
   * @param command UnAssignEpsFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignEps(UnAssignEpsFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Eps on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv1 on GovHydroPID
   *
   * @param command AssignGv1ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignGv1(AssignGv1ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Gv1 on GovHydroPID
   *
   * @param command UnAssignGv1FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignGv1(UnAssignGv1FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv1 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv2 on GovHydroPID
   *
   * @param command AssignGv2ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignGv2(AssignGv2ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Gv2 on GovHydroPID
   *
   * @param command UnAssignGv2FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignGv2(UnAssignGv2FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv2 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv3 on GovHydroPID
   *
   * @param command AssignGv3ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignGv3(AssignGv3ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Gv3 on GovHydroPID
   *
   * @param command UnAssignGv3FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignGv3(UnAssignGv3FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv3 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv4 on GovHydroPID
   *
   * @param command AssignGv4ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignGv4(AssignGv4ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Gv4 on GovHydroPID
   *
   * @param command UnAssignGv4FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignGv4(UnAssignGv4FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv4 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv5 on GovHydroPID
   *
   * @param command AssignGv5ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignGv5(AssignGv5ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Gv5 on GovHydroPID
   *
   * @param command UnAssignGv5FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignGv5(UnAssignGv5FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv5 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gv6 on GovHydroPID
   *
   * @param command AssignGv6ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignGv6(AssignGv6ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Gv6 on GovHydroPID
   *
   * @param command UnAssignGv6FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignGv6(UnAssignGv6FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gv6 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign InputSignal on GovHydroPID
   *
   * @param command AssignInputSignalToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignInputSignal(AssignInputSignalToGovHydroPIDCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign InputSignal on GovHydroPID
   *
   * @param command UnAssignInputSignalFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignInputSignal(UnAssignInputSignalFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign InputSignal on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kd on GovHydroPID
   *
   * @param command AssignKdToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignKd(AssignKdToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Kd on GovHydroPID
   *
   * @param command UnAssignKdFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignKd(UnAssignKdFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kd on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kg on GovHydroPID
   *
   * @param command AssignKgToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignKg(AssignKgToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Kg on GovHydroPID
   *
   * @param command UnAssignKgFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignKg(UnAssignKgFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kg on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ki on GovHydroPID
   *
   * @param command AssignKiToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignKi(AssignKiToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Ki on GovHydroPID
   *
   * @param command UnAssignKiFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignKi(UnAssignKiFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ki on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kp on GovHydroPID
   *
   * @param command AssignKpToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignKp(AssignKpToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Kp on GovHydroPID
   *
   * @param command UnAssignKpFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignKp(UnAssignKpFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kp on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwbase on GovHydroPID
   *
   * @param command AssignMwbaseToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignMwbase(AssignMwbaseToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Mwbase on GovHydroPID
   *
   * @param command UnAssignMwbaseFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignMwbase(UnAssignMwbaseFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwbase on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv1 on GovHydroPID
   *
   * @param command AssignPgv1ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPgv1(AssignPgv1ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pgv1 on GovHydroPID
   *
   * @param command UnAssignPgv1FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPgv1(UnAssignPgv1FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv1 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv2 on GovHydroPID
   *
   * @param command AssignPgv2ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPgv2(AssignPgv2ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pgv2 on GovHydroPID
   *
   * @param command UnAssignPgv2FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPgv2(UnAssignPgv2FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv2 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv3 on GovHydroPID
   *
   * @param command AssignPgv3ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPgv3(AssignPgv3ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pgv3 on GovHydroPID
   *
   * @param command UnAssignPgv3FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPgv3(UnAssignPgv3FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv3 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv4 on GovHydroPID
   *
   * @param command AssignPgv4ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPgv4(AssignPgv4ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pgv4 on GovHydroPID
   *
   * @param command UnAssignPgv4FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPgv4(UnAssignPgv4FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv4 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv5 on GovHydroPID
   *
   * @param command AssignPgv5ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPgv5(AssignPgv5ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pgv5 on GovHydroPID
   *
   * @param command UnAssignPgv5FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPgv5(UnAssignPgv5FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv5 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pgv6 on GovHydroPID
   *
   * @param command AssignPgv6ToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPgv6(AssignPgv6ToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pgv6 on GovHydroPID
   *
   * @param command UnAssignPgv6FromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPgv6(UnAssignPgv6FromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pgv6 on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmax on GovHydroPID
   *
   * @param command AssignPmaxToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPmax(AssignPmaxToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pmax on GovHydroPID
   *
   * @param command UnAssignPmaxFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPmax(UnAssignPmaxFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmax on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmin on GovHydroPID
   *
   * @param command AssignPminToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignPmin(AssignPminToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Pmin on GovHydroPID
   *
   * @param command UnAssignPminFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignPmin(UnAssignPminFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmin on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on GovHydroPID
   *
   * @param command AssignRToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign R on GovHydroPID
   *
   * @param command UnAssignRFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Td on GovHydroPID
   *
   * @param command AssignTdToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignTd(AssignTdToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Td on GovHydroPID
   *
   * @param command UnAssignTdFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignTd(UnAssignTdFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Td on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on GovHydroPID
   *
   * @param command AssignTfToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Tf on GovHydroPID
   *
   * @param command UnAssignTfFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tp on GovHydroPID
   *
   * @param command AssignTpToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignTp(AssignTpToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Tp on GovHydroPID
   *
   * @param command UnAssignTpFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignTp(UnAssignTpFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tp on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tt on GovHydroPID
   *
   * @param command AssignTtToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignTt(AssignTtToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Tt on GovHydroPID
   *
   * @param command UnAssignTtFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignTt(UnAssignTtFromGovHydroPIDCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tt on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tturb on GovHydroPID
   *
   * @param command AssignTturbToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignTturb(AssignTturbToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Tturb on GovHydroPID
   *
   * @param command UnAssignTturbFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignTturb(UnAssignTturbFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tturb on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Velcl on GovHydroPID
   *
   * @param command AssignVelclToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignVelcl(AssignVelclToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Velcl on GovHydroPID
   *
   * @param command UnAssignVelclFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignVelcl(UnAssignVelclFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Velcl on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Velop on GovHydroPID
   *
   * @param command AssignVelopToGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void assignVelop(AssignVelopToGovHydroPIDCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPIDId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydroPIDBusinessDelegate parentDelegate =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

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
   * unAssign Velop on GovHydroPID
   *
   * @param command UnAssignVelopFromGovHydroPIDCommand
   * @exception ProcessingException
   */
  public void unAssignVelop(UnAssignVelopFromGovHydroPIDCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPIDValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Velop on GovHydroPID";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovHydroPID
   */
  private GovHydroPID load(UUID id) throws ProcessingException {
    govHydroPID =
        GovHydroPIDBusinessDelegate.getGovHydroPIDInstance()
            .getGovHydroPID(new GovHydroPIDFetchOneSummary(id));
    return govHydroPID;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovHydroPID govHydroPID = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroPIDBusinessDelegate.class.getName());
}
