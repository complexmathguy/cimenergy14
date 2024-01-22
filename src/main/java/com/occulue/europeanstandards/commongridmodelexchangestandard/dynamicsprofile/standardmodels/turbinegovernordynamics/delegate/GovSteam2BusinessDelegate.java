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
 * GovSteam2 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovSteam2 related services in the case of a GovSteam2 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform GovSteam2 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovSteam2 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovSteam2BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovSteam2BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovSteam2 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovSteam2BusinessDelegate
   */
  public static GovSteam2BusinessDelegate getGovSteam2Instance() {
    return (new GovSteam2BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovSteam2(CreateGovSteam2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovSteam2Id() == null) command.setGovSteam2Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovSteam2Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovSteam2Command of GovSteam2 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovSteam2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovSteam2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovSteam2(UpdateGovSteam2Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovSteam2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovSteam2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovSteam2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovSteam2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovSteam2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete GovSteam2 using Id = " + command.getGovSteam2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovSteam2 via GovSteam2FetchOneSummary
   *
   * @param summary GovSteam2FetchOneSummary
   * @return GovSteam2FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovSteam2 getGovSteam2(GovSteam2FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovSteam2FetchOneSummary arg cannot be null");

    GovSteam2 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovSteam2
      // --------------------------------------
      CompletableFuture<GovSteam2> futureEntity =
          queryGateway.query(
              new FindGovSteam2Query(new LoadGovSteam2Filter(summary.getGovSteam2Id())),
              ResponseTypes.instanceOf(GovSteam2.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate GovSteam2 with id " + summary.getGovSteam2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovSteam2s
   *
   * @return List<GovSteam2>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovSteam2> getAllGovSteam2() throws ProcessingException {
    List<GovSteam2> list = null;

    try {
      CompletableFuture<List<GovSteam2>> futureList =
          queryGateway.query(
              new FindAllGovSteam2Query(), ResponseTypes.multipleInstancesOf(GovSteam2.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovSteam2";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Dbf on GovSteam2
   *
   * @param command AssignDbfToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignDbf(AssignDbfToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign Dbf on GovSteam2
   *
   * @param command UnAssignDbfFromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignDbf(UnAssignDbfFromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dbf on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign K on GovSteam2
   *
   * @param command AssignKToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignK(AssignKToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign K on GovSteam2
   *
   * @param command UnAssignKFromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignK(UnAssignKFromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mnef on GovSteam2
   *
   * @param command AssignMnefToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignMnef(AssignMnefToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign Mnef on GovSteam2
   *
   * @param command UnAssignMnefFromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignMnef(UnAssignMnefFromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mnef on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mxef on GovSteam2
   *
   * @param command AssignMxefToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignMxef(AssignMxefToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign Mxef on GovSteam2
   *
   * @param command UnAssignMxefFromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignMxef(UnAssignMxefFromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mxef on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmax on GovSteam2
   *
   * @param command AssignPmaxToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignPmax(AssignPmaxToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign Pmax on GovSteam2
   *
   * @param command UnAssignPmaxFromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignPmax(UnAssignPmaxFromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmax on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmin on GovSteam2
   *
   * @param command AssignPminToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignPmin(AssignPminToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign Pmin on GovSteam2
   *
   * @param command UnAssignPminFromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignPmin(UnAssignPminFromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmin on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on GovSteam2
   *
   * @param command AssignT1ToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign T1 on GovSteam2
   *
   * @param command UnAssignT1FromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on GovSteam2
   *
   * @param command AssignT2ToGovSteam2Command
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToGovSteam2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovSteam2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovSteam2BusinessDelegate parentDelegate = GovSteam2BusinessDelegate.getGovSteam2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

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
   * unAssign T2 on GovSteam2
   *
   * @param command UnAssignT2FromGovSteam2Command
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromGovSteam2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovSteam2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on GovSteam2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovSteam2
   */
  private GovSteam2 load(UUID id) throws ProcessingException {
    govSteam2 =
        GovSteam2BusinessDelegate.getGovSteam2Instance()
            .getGovSteam2(new GovSteam2FetchOneSummary(id));
    return govSteam2;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovSteam2 govSteam2 = null;
  private static final Logger LOGGER = Logger.getLogger(GovSteam2BusinessDelegate.class.getName());
}
