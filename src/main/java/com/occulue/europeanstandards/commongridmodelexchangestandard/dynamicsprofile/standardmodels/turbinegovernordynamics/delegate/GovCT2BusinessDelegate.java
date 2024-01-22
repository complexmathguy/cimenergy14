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
 * GovCT2 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovCT2 related services in the case of a GovCT2 business related
 *       service failing.
 *   <li>Exposes a simpler, uniform GovCT2 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovCT2 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovCT2BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovCT2BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovCT2 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovCT2BusinessDelegate
   */
  public static GovCT2BusinessDelegate getGovCT2Instance() {
    return (new GovCT2BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovCT2(CreateGovCT2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovCT2Id() == null) command.setGovCT2Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovCT2Command - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovCT2Command of GovCT2 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovCT2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovCT2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovCT2(UpdateGovCT2Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovCT2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovCT2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovCT2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovCT2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovCT2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete GovCT2 using Id = " + command.getGovCT2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovCT2 via GovCT2FetchOneSummary
   *
   * @param summary GovCT2FetchOneSummary
   * @return GovCT2FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovCT2 getGovCT2(GovCT2FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovCT2FetchOneSummary arg cannot be null");

    GovCT2 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovCT2Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovCT2
      // --------------------------------------
      CompletableFuture<GovCT2> futureEntity =
          queryGateway.query(
              new FindGovCT2Query(new LoadGovCT2Filter(summary.getGovCT2Id())),
              ResponseTypes.instanceOf(GovCT2.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate GovCT2 with id " + summary.getGovCT2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovCT2s
   *
   * @return List<GovCT2>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovCT2> getAllGovCT2() throws ProcessingException {
    List<GovCT2> list = null;

    try {
      CompletableFuture<List<GovCT2>> futureList =
          queryGateway.query(
              new FindAllGovCT2Query(), ResponseTypes.multipleInstancesOf(GovCT2.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovCT2";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Aset on GovCT2
   *
   * @param command AssignAsetToGovCT2Command
   * @exception ProcessingException
   */
  public void assignAset(AssignAsetToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Aset on GovCT2
   *
   * @param command UnAssignAsetFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignAset(UnAssignAsetFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Aset on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db on GovCT2
   *
   * @param command AssignDbToGovCT2Command
   * @exception ProcessingException
   */
  public void assignDb(AssignDbToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Db on GovCT2
   *
   * @param command UnAssignDbFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignDb(UnAssignDbFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dm on GovCT2
   *
   * @param command AssignDmToGovCT2Command
   * @exception ProcessingException
   */
  public void assignDm(AssignDmToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Dm on GovCT2
   *
   * @param command UnAssignDmFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignDm(UnAssignDmFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dm on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim1 on GovCT2
   *
   * @param command AssignFlim1ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim1(AssignFlim1ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim1 on GovCT2
   *
   * @param command UnAssignFlim1FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim1(UnAssignFlim1FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim1 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim10 on GovCT2
   *
   * @param command AssignFlim10ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim10(AssignFlim10ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim10 on GovCT2
   *
   * @param command UnAssignFlim10FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim10(UnAssignFlim10FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim10 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim2 on GovCT2
   *
   * @param command AssignFlim2ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim2(AssignFlim2ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim2 on GovCT2
   *
   * @param command UnAssignFlim2FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim2(UnAssignFlim2FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim2 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim3 on GovCT2
   *
   * @param command AssignFlim3ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim3(AssignFlim3ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim3 on GovCT2
   *
   * @param command UnAssignFlim3FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim3(UnAssignFlim3FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim3 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim4 on GovCT2
   *
   * @param command AssignFlim4ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim4(AssignFlim4ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim4 on GovCT2
   *
   * @param command UnAssignFlim4FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim4(UnAssignFlim4FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim4 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim5 on GovCT2
   *
   * @param command AssignFlim5ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim5(AssignFlim5ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim5 on GovCT2
   *
   * @param command UnAssignFlim5FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim5(UnAssignFlim5FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim5 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim6 on GovCT2
   *
   * @param command AssignFlim6ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim6(AssignFlim6ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim6 on GovCT2
   *
   * @param command UnAssignFlim6FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim6(UnAssignFlim6FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim6 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim7 on GovCT2
   *
   * @param command AssignFlim7ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim7(AssignFlim7ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim7 on GovCT2
   *
   * @param command UnAssignFlim7FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim7(UnAssignFlim7FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim7 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim8 on GovCT2
   *
   * @param command AssignFlim8ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim8(AssignFlim8ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim8 on GovCT2
   *
   * @param command UnAssignFlim8FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim8(UnAssignFlim8FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim8 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Flim9 on GovCT2
   *
   * @param command AssignFlim9ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignFlim9(AssignFlim9ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Flim9 on GovCT2
   *
   * @param command UnAssignFlim9FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignFlim9(UnAssignFlim9FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Flim9 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ka on GovCT2
   *
   * @param command AssignKaToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKa(AssignKaToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Ka on GovCT2
   *
   * @param command UnAssignKaFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKa(UnAssignKaFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ka on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kdgov on GovCT2
   *
   * @param command AssignKdgovToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKdgov(AssignKdgovToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kdgov on GovCT2
   *
   * @param command UnAssignKdgovFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKdgov(UnAssignKdgovFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kdgov on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kigov on GovCT2
   *
   * @param command AssignKigovToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKigov(AssignKigovToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kigov on GovCT2
   *
   * @param command UnAssignKigovFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKigov(UnAssignKigovFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kigov on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kiload on GovCT2
   *
   * @param command AssignKiloadToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKiload(AssignKiloadToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kiload on GovCT2
   *
   * @param command UnAssignKiloadFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKiload(UnAssignKiloadFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kiload on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kimw on GovCT2
   *
   * @param command AssignKimwToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKimw(AssignKimwToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kimw on GovCT2
   *
   * @param command UnAssignKimwFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKimw(UnAssignKimwFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kimw on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpgov on GovCT2
   *
   * @param command AssignKpgovToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKpgov(AssignKpgovToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kpgov on GovCT2
   *
   * @param command UnAssignKpgovFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKpgov(UnAssignKpgovFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpgov on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpload on GovCT2
   *
   * @param command AssignKploadToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKpload(AssignKploadToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kpload on GovCT2
   *
   * @param command UnAssignKploadFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKpload(UnAssignKploadFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpload on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kturb on GovCT2
   *
   * @param command AssignKturbToGovCT2Command
   * @exception ProcessingException
   */
  public void assignKturb(AssignKturbToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Kturb on GovCT2
   *
   * @param command UnAssignKturbFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignKturb(UnAssignKturbFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kturb on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ldref on GovCT2
   *
   * @param command AssignLdrefToGovCT2Command
   * @exception ProcessingException
   */
  public void assignLdref(AssignLdrefToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Ldref on GovCT2
   *
   * @param command UnAssignLdrefFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignLdref(UnAssignLdrefFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ldref on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Maxerr on GovCT2
   *
   * @param command AssignMaxerrToGovCT2Command
   * @exception ProcessingException
   */
  public void assignMaxerr(AssignMaxerrToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Maxerr on GovCT2
   *
   * @param command UnAssignMaxerrFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignMaxerr(UnAssignMaxerrFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Maxerr on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Minerr on GovCT2
   *
   * @param command AssignMinerrToGovCT2Command
   * @exception ProcessingException
   */
  public void assignMinerr(AssignMinerrToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Minerr on GovCT2
   *
   * @param command UnAssignMinerrFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignMinerr(UnAssignMinerrFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Minerr on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwbase on GovCT2
   *
   * @param command AssignMwbaseToGovCT2Command
   * @exception ProcessingException
   */
  public void assignMwbase(AssignMwbaseToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Mwbase on GovCT2
   *
   * @param command UnAssignMwbaseFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignMwbase(UnAssignMwbaseFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwbase on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim1 on GovCT2
   *
   * @param command AssignPlim1ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim1(AssignPlim1ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim1 on GovCT2
   *
   * @param command UnAssignPlim1FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim1(UnAssignPlim1FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim1 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim10 on GovCT2
   *
   * @param command AssignPlim10ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim10(AssignPlim10ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim10 on GovCT2
   *
   * @param command UnAssignPlim10FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim10(UnAssignPlim10FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim10 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim2 on GovCT2
   *
   * @param command AssignPlim2ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim2(AssignPlim2ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim2 on GovCT2
   *
   * @param command UnAssignPlim2FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim2(UnAssignPlim2FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim2 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim3 on GovCT2
   *
   * @param command AssignPlim3ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim3(AssignPlim3ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim3 on GovCT2
   *
   * @param command UnAssignPlim3FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim3(UnAssignPlim3FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim3 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim4 on GovCT2
   *
   * @param command AssignPlim4ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim4(AssignPlim4ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim4 on GovCT2
   *
   * @param command UnAssignPlim4FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim4(UnAssignPlim4FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim4 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim5 on GovCT2
   *
   * @param command AssignPlim5ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim5(AssignPlim5ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim5 on GovCT2
   *
   * @param command UnAssignPlim5FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim5(UnAssignPlim5FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim5 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim6 on GovCT2
   *
   * @param command AssignPlim6ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim6(AssignPlim6ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim6 on GovCT2
   *
   * @param command UnAssignPlim6FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim6(UnAssignPlim6FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim6 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim7 on GovCT2
   *
   * @param command AssignPlim7ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim7(AssignPlim7ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim7 on GovCT2
   *
   * @param command UnAssignPlim7FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim7(UnAssignPlim7FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim7 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim8 on GovCT2
   *
   * @param command AssignPlim8ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim8(AssignPlim8ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim8 on GovCT2
   *
   * @param command UnAssignPlim8FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim8(UnAssignPlim8FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim8 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Plim9 on GovCT2
   *
   * @param command AssignPlim9ToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPlim9(AssignPlim9ToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Plim9 on GovCT2
   *
   * @param command UnAssignPlim9FromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPlim9(UnAssignPlim9FromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Plim9 on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Prate on GovCT2
   *
   * @param command AssignPrateToGovCT2Command
   * @exception ProcessingException
   */
  public void assignPrate(AssignPrateToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Prate on GovCT2
   *
   * @param command UnAssignPrateFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignPrate(UnAssignPrateFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Prate on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on GovCT2
   *
   * @param command AssignRToGovCT2Command
   * @exception ProcessingException
   */
  public void assignR(AssignRToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign R on GovCT2
   *
   * @param command UnAssignRFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rclose on GovCT2
   *
   * @param command AssignRcloseToGovCT2Command
   * @exception ProcessingException
   */
  public void assignRclose(AssignRcloseToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Rclose on GovCT2
   *
   * @param command UnAssignRcloseFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignRclose(UnAssignRcloseFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rclose on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rdown on GovCT2
   *
   * @param command AssignRdownToGovCT2Command
   * @exception ProcessingException
   */
  public void assignRdown(AssignRdownToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Rdown on GovCT2
   *
   * @param command UnAssignRdownFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignRdown(UnAssignRdownFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rdown on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ropen on GovCT2
   *
   * @param command AssignRopenToGovCT2Command
   * @exception ProcessingException
   */
  public void assignRopen(AssignRopenToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Ropen on GovCT2
   *
   * @param command UnAssignRopenFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignRopen(UnAssignRopenFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ropen on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rup on GovCT2
   *
   * @param command AssignRupToGovCT2Command
   * @exception ProcessingException
   */
  public void assignRup(AssignRupToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Rup on GovCT2
   *
   * @param command UnAssignRupFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignRup(UnAssignRupFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rup on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ta on GovCT2
   *
   * @param command AssignTaToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTa(AssignTaToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Ta on GovCT2
   *
   * @param command UnAssignTaFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTa(UnAssignTaFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ta on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tact on GovCT2
   *
   * @param command AssignTactToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTact(AssignTactToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tact on GovCT2
   *
   * @param command UnAssignTactFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTact(UnAssignTactFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tact on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tb on GovCT2
   *
   * @param command AssignTbToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTb(AssignTbToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tb on GovCT2
   *
   * @param command UnAssignTbFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTb(UnAssignTbFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tb on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tc on GovCT2
   *
   * @param command AssignTcToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTc(AssignTcToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tc on GovCT2
   *
   * @param command UnAssignTcFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTc(UnAssignTcFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tc on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tdgov on GovCT2
   *
   * @param command AssignTdgovToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTdgov(AssignTdgovToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tdgov on GovCT2
   *
   * @param command UnAssignTdgovFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTdgov(UnAssignTdgovFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tdgov on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Teng on GovCT2
   *
   * @param command AssignTengToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTeng(AssignTengToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Teng on GovCT2
   *
   * @param command UnAssignTengFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTeng(UnAssignTengFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Teng on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tfload on GovCT2
   *
   * @param command AssignTfloadToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTfload(AssignTfloadToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tfload on GovCT2
   *
   * @param command UnAssignTfloadFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTfload(UnAssignTfloadFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tfload on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpelec on GovCT2
   *
   * @param command AssignTpelecToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTpelec(AssignTpelecToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tpelec on GovCT2
   *
   * @param command UnAssignTpelecFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTpelec(UnAssignTpelecFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpelec on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tsa on GovCT2
   *
   * @param command AssignTsaToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTsa(AssignTsaToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tsa on GovCT2
   *
   * @param command UnAssignTsaFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTsa(UnAssignTsaFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tsa on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tsb on GovCT2
   *
   * @param command AssignTsbToGovCT2Command
   * @exception ProcessingException
   */
  public void assignTsb(AssignTsbToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Tsb on GovCT2
   *
   * @param command UnAssignTsbFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignTsb(UnAssignTsbFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tsb on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vmax on GovCT2
   *
   * @param command AssignVmaxToGovCT2Command
   * @exception ProcessingException
   */
  public void assignVmax(AssignVmaxToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Vmax on GovCT2
   *
   * @param command UnAssignVmaxFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignVmax(UnAssignVmaxFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vmax on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vmin on GovCT2
   *
   * @param command AssignVminToGovCT2Command
   * @exception ProcessingException
   */
  public void assignVmin(AssignVminToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Vmin on GovCT2
   *
   * @param command UnAssignVminFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignVmin(UnAssignVminFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vmin on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Wfnl on GovCT2
   *
   * @param command AssignWfnlToGovCT2Command
   * @exception ProcessingException
   */
  public void assignWfnl(AssignWfnlToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Wfnl on GovCT2
   *
   * @param command UnAssignWfnlFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignWfnl(UnAssignWfnlFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Wfnl on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Wfspd on GovCT2
   *
   * @param command AssignWfspdToGovCT2Command
   * @exception ProcessingException
   */
  public void assignWfspd(AssignWfspdToGovCT2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovCT2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovCT2BusinessDelegate parentDelegate = GovCT2BusinessDelegate.getGovCT2Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

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
   * unAssign Wfspd on GovCT2
   *
   * @param command UnAssignWfspdFromGovCT2Command
   * @exception ProcessingException
   */
  public void unAssignWfspd(UnAssignWfspdFromGovCT2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovCT2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Wfspd on GovCT2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovCT2
   */
  private GovCT2 load(UUID id) throws ProcessingException {
    govCT2 = GovCT2BusinessDelegate.getGovCT2Instance().getGovCT2(new GovCT2FetchOneSummary(id));
    return govCT2;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovCT2 govCT2 = null;
  private static final Logger LOGGER = Logger.getLogger(GovCT2BusinessDelegate.class.getName());
}
