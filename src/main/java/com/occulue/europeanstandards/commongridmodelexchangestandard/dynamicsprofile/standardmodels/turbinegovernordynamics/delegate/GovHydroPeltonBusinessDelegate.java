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
 * GovHydroPelton business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovHydroPelton related services in the case of a GovHydroPelton
 *       business related service failing.
 *   <li>Exposes a simpler, uniform GovHydroPelton interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovHydroPelton business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovHydroPeltonBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovHydroPeltonBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovHydroPelton Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovHydroPeltonBusinessDelegate
   */
  public static GovHydroPeltonBusinessDelegate getGovHydroPeltonInstance() {
    return (new GovHydroPeltonBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovHydroPelton(CreateGovHydroPeltonCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovHydroPeltonId() == null) command.setGovHydroPeltonId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovHydroPeltonCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovHydroPeltonCommand of GovHydroPelton is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovHydroPelton - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovHydroPeltonCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovHydroPelton(UpdateGovHydroPeltonCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovHydroPeltonCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovHydroPelton - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovHydroPeltonCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovHydroPeltonCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovHydroPeltonCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GovHydroPelton using Id = " + command.getGovHydroPeltonId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovHydroPelton via GovHydroPeltonFetchOneSummary
   *
   * @param summary GovHydroPeltonFetchOneSummary
   * @return GovHydroPeltonFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovHydroPelton getGovHydroPelton(GovHydroPeltonFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovHydroPeltonFetchOneSummary arg cannot be null");

    GovHydroPelton entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovHydroPelton
      // --------------------------------------
      CompletableFuture<GovHydroPelton> futureEntity =
          queryGateway.query(
              new FindGovHydroPeltonQuery(
                  new LoadGovHydroPeltonFilter(summary.getGovHydroPeltonId())),
              ResponseTypes.instanceOf(GovHydroPelton.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GovHydroPelton with id " + summary.getGovHydroPeltonId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovHydroPeltons
   *
   * @return List<GovHydroPelton>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovHydroPelton> getAllGovHydroPelton() throws ProcessingException {
    List<GovHydroPelton> list = null;

    try {
      CompletableFuture<List<GovHydroPelton>> futureList =
          queryGateway.query(
              new FindAllGovHydroPeltonQuery(),
              ResponseTypes.multipleInstancesOf(GovHydroPelton.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovHydroPelton";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Av0 on GovHydroPelton
   *
   * @param command AssignAv0ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignAv0(AssignAv0ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AreaBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AreaBusinessDelegate.getAreaInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getAreaId();
    Area child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Area using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Av0 on GovHydroPelton
   *
   * @param command UnAssignAv0FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignAv0(UnAssignAv0FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Av0 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Av1 on GovHydroPelton
   *
   * @param command AssignAv1ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignAv1(AssignAv1ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AreaBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AreaBusinessDelegate.getAreaInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getAreaId();
    Area child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Area using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Av1 on GovHydroPelton
   *
   * @param command UnAssignAv1FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignAv1(UnAssignAv1FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Av1 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Bp on GovHydroPelton
   *
   * @param command AssignBpToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignBp(AssignBpToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Bp on GovHydroPelton
   *
   * @param command UnAssignBpFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignBp(UnAssignBpFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Bp on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db1 on GovHydroPelton
   *
   * @param command AssignDb1ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignDb1(AssignDb1ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Db1 on GovHydroPelton
   *
   * @param command UnAssignDb1FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignDb1(UnAssignDb1FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db1 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db2 on GovHydroPelton
   *
   * @param command AssignDb2ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignDb2(AssignDb2ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Db2 on GovHydroPelton
   *
   * @param command UnAssignDb2FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignDb2(UnAssignDb2FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db2 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign H1 on GovHydroPelton
   *
   * @param command AssignH1ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignH1(AssignH1ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign H1 on GovHydroPelton
   *
   * @param command UnAssignH1FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignH1(UnAssignH1FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign H1 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign H2 on GovHydroPelton
   *
   * @param command AssignH2ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignH2(AssignH2ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign H2 on GovHydroPelton
   *
   * @param command UnAssignH2FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignH2(UnAssignH2FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign H2 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Hn on GovHydroPelton
   *
   * @param command AssignHnToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignHn(AssignHnToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Hn on GovHydroPelton
   *
   * @param command UnAssignHnFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignHn(UnAssignHnFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Hn on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kc on GovHydroPelton
   *
   * @param command AssignKcToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignKc(AssignKcToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Kc on GovHydroPelton
   *
   * @param command UnAssignKcFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignKc(UnAssignKcFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kc on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kg on GovHydroPelton
   *
   * @param command AssignKgToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignKg(AssignKgToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Kg on GovHydroPelton
   *
   * @param command UnAssignKgFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignKg(UnAssignKgFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kg on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qc0 on GovHydroPelton
   *
   * @param command AssignQc0ToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignQc0(AssignQc0ToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Qc0 on GovHydroPelton
   *
   * @param command UnAssignQc0FromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignQc0(UnAssignQc0FromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qc0 on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qn on GovHydroPelton
   *
   * @param command AssignQnToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignQn(AssignQnToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VolumeFlowRateBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getVolumeFlowRateId();
    VolumeFlowRate child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get VolumeFlowRate using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Qn on GovHydroPelton
   *
   * @param command UnAssignQnFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignQn(UnAssignQnFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qn on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SimplifiedPelton on GovHydroPelton
   *
   * @param command AssignSimplifiedPeltonToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignSimplifiedPelton(AssignSimplifiedPeltonToGovHydroPeltonCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign SimplifiedPelton on GovHydroPelton
   *
   * @param command UnAssignSimplifiedPeltonFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignSimplifiedPelton(UnAssignSimplifiedPeltonFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SimplifiedPelton on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign StaticCompensating on GovHydroPelton
   *
   * @param command AssignStaticCompensatingToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignStaticCompensating(AssignStaticCompensatingToGovHydroPeltonCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign StaticCompensating on GovHydroPelton
   *
   * @param command UnAssignStaticCompensatingFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignStaticCompensating(
      UnAssignStaticCompensatingFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign StaticCompensating on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ta on GovHydroPelton
   *
   * @param command AssignTaToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignTa(AssignTaToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Ta on GovHydroPelton
   *
   * @param command UnAssignTaFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignTa(UnAssignTaFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ta on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ts on GovHydroPelton
   *
   * @param command AssignTsToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignTs(AssignTsToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Ts on GovHydroPelton
   *
   * @param command UnAssignTsFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignTs(UnAssignTsFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ts on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tv on GovHydroPelton
   *
   * @param command AssignTvToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignTv(AssignTvToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Tv on GovHydroPelton
   *
   * @param command UnAssignTvFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignTv(UnAssignTvFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tv on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twnc on GovHydroPelton
   *
   * @param command AssignTwncToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignTwnc(AssignTwncToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Twnc on GovHydroPelton
   *
   * @param command UnAssignTwncFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignTwnc(UnAssignTwncFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twnc on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twng on GovHydroPelton
   *
   * @param command AssignTwngToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignTwng(AssignTwngToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Twng on GovHydroPelton
   *
   * @param command UnAssignTwngFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignTwng(UnAssignTwngFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twng on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tx on GovHydroPelton
   *
   * @param command AssignTxToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignTx(AssignTxToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Tx on GovHydroPelton
   *
   * @param command UnAssignTxFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignTx(UnAssignTxFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tx on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Va on GovHydroPelton
   *
   * @param command AssignVaToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignVa(AssignVaToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Va on GovHydroPelton
   *
   * @param command UnAssignVaFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignVa(UnAssignVaFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Va on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Valvmax on GovHydroPelton
   *
   * @param command AssignValvmaxToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignValvmax(AssignValvmaxToGovHydroPeltonCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Valvmax on GovHydroPelton
   *
   * @param command UnAssignValvmaxFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignValvmax(UnAssignValvmaxFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Valvmax on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Valvmin on GovHydroPelton
   *
   * @param command AssignValvminToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignValvmin(AssignValvminToGovHydroPeltonCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Valvmin on GovHydroPelton
   *
   * @param command UnAssignValvminFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignValvmin(UnAssignValvminFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Valvmin on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vav on GovHydroPelton
   *
   * @param command AssignVavToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignVav(AssignVavToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Vav on GovHydroPelton
   *
   * @param command UnAssignVavFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignVav(UnAssignVavFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vav on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vc on GovHydroPelton
   *
   * @param command AssignVcToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignVc(AssignVcToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Vc on GovHydroPelton
   *
   * @param command UnAssignVcFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignVc(UnAssignVcFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vc on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vcv on GovHydroPelton
   *
   * @param command AssignVcvToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignVcv(AssignVcvToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign Vcv on GovHydroPelton
   *
   * @param command UnAssignVcvFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignVcv(UnAssignVcvFromGovHydroPeltonCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vcv on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign WaterTunnelSurgeChamberSimulation on GovHydroPelton
   *
   * @param command AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignWaterTunnelSurgeChamberSimulation(
      AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

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
   * unAssign WaterTunnelSurgeChamberSimulation on GovHydroPelton
   *
   * @param command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignWaterTunnelSurgeChamberSimulation(
      UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WaterTunnelSurgeChamberSimulation on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Zsfc on GovHydroPelton
   *
   * @param command AssignZsfcToGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void assignZsfc(AssignZsfcToGovHydroPeltonCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroPeltonId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroPeltonBusinessDelegate parentDelegate =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Zsfc on GovHydroPelton
   *
   * @param command UnAssignZsfcFromGovHydroPeltonCommand
   * @exception ProcessingException
   */
  public void unAssignZsfc(UnAssignZsfcFromGovHydroPeltonCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroPeltonValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Zsfc on GovHydroPelton";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovHydroPelton
   */
  private GovHydroPelton load(UUID id) throws ProcessingException {
    govHydroPelton =
        GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance()
            .getGovHydroPelton(new GovHydroPeltonFetchOneSummary(id));
    return govHydroPelton;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovHydroPelton govHydroPelton = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroPeltonBusinessDelegate.class.getName());
}
