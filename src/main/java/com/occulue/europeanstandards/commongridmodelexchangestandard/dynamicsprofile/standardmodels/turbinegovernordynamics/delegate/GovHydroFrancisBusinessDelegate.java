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
 * GovHydroFrancis business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GovHydroFrancis related services in the case of a
 *       GovHydroFrancis business related service failing.
 *   <li>Exposes a simpler, uniform GovHydroFrancis interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GovHydroFrancis business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GovHydroFrancisBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GovHydroFrancisBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GovHydroFrancis Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GovHydroFrancisBusinessDelegate
   */
  public static GovHydroFrancisBusinessDelegate getGovHydroFrancisInstance() {
    return (new GovHydroFrancisBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGovHydroFrancis(CreateGovHydroFrancisCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGovHydroFrancisId() == null) command.setGovHydroFrancisId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGovHydroFrancisCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGovHydroFrancisCommand of GovHydroFrancis is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GovHydroFrancis - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGovHydroFrancisCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGovHydroFrancis(UpdateGovHydroFrancisCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGovHydroFrancisCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GovHydroFrancis - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGovHydroFrancisCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGovHydroFrancisCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGovHydroFrancisCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GovHydroFrancis using Id = " + command.getGovHydroFrancisId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GovHydroFrancis via GovHydroFrancisFetchOneSummary
   *
   * @param summary GovHydroFrancisFetchOneSummary
   * @return GovHydroFrancisFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GovHydroFrancis getGovHydroFrancis(GovHydroFrancisFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("GovHydroFrancisFetchOneSummary arg cannot be null");

    GovHydroFrancis entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GovHydroFrancis
      // --------------------------------------
      CompletableFuture<GovHydroFrancis> futureEntity =
          queryGateway.query(
              new FindGovHydroFrancisQuery(
                  new LoadGovHydroFrancisFilter(summary.getGovHydroFrancisId())),
              ResponseTypes.instanceOf(GovHydroFrancis.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GovHydroFrancis with id " + summary.getGovHydroFrancisId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GovHydroFranciss
   *
   * @return List<GovHydroFrancis>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GovHydroFrancis> getAllGovHydroFrancis() throws ProcessingException {
    List<GovHydroFrancis> list = null;

    try {
      CompletableFuture<List<GovHydroFrancis>> futureList =
          queryGateway.query(
              new FindAllGovHydroFrancisQuery(),
              ResponseTypes.multipleInstancesOf(GovHydroFrancis.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GovHydroFrancis";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Am on GovHydroFrancis
   *
   * @param command AssignAmToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignAm(AssignAmToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Am on GovHydroFrancis
   *
   * @param command UnAssignAmFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignAm(UnAssignAmFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Am on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Av0 on GovHydroFrancis
   *
   * @param command AssignAv0ToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignAv0(AssignAv0ToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AreaBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AreaBusinessDelegate.getAreaInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getAreaId();
    Area child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Av0 on GovHydroFrancis
   *
   * @param command UnAssignAv0FromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignAv0(UnAssignAv0FromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Av0 on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Av1 on GovHydroFrancis
   *
   * @param command AssignAv1ToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignAv1(AssignAv1ToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AreaBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AreaBusinessDelegate.getAreaInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getAreaId();
    Area child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Av1 on GovHydroFrancis
   *
   * @param command UnAssignAv1FromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignAv1(UnAssignAv1FromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Av1 on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Bp on GovHydroFrancis
   *
   * @param command AssignBpToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignBp(AssignBpToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Bp on GovHydroFrancis
   *
   * @param command UnAssignBpFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignBp(UnAssignBpFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Bp on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Db1 on GovHydroFrancis
   *
   * @param command AssignDb1ToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignDb1(AssignDb1ToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Db1 on GovHydroFrancis
   *
   * @param command UnAssignDb1FromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignDb1(UnAssignDb1FromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db1 on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Etamax on GovHydroFrancis
   *
   * @param command AssignEtamaxToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignEtamax(AssignEtamaxToGovHydroFrancisCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Etamax on GovHydroFrancis
   *
   * @param command UnAssignEtamaxFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignEtamax(UnAssignEtamaxFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Etamax on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign H1 on GovHydroFrancis
   *
   * @param command AssignH1ToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignH1(AssignH1ToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign H1 on GovHydroFrancis
   *
   * @param command UnAssignH1FromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignH1(UnAssignH1FromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign H1 on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign H2 on GovHydroFrancis
   *
   * @param command AssignH2ToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignH2(AssignH2ToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign H2 on GovHydroFrancis
   *
   * @param command UnAssignH2FromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignH2(UnAssignH2FromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign H2 on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Hn on GovHydroFrancis
   *
   * @param command AssignHnToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignHn(AssignHnToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Hn on GovHydroFrancis
   *
   * @param command UnAssignHnFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignHn(UnAssignHnFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Hn on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kc on GovHydroFrancis
   *
   * @param command AssignKcToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignKc(AssignKcToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Kc on GovHydroFrancis
   *
   * @param command UnAssignKcFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignKc(UnAssignKcFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kc on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kg on GovHydroFrancis
   *
   * @param command AssignKgToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignKg(AssignKgToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Kg on GovHydroFrancis
   *
   * @param command UnAssignKgFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignKg(UnAssignKgFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kg on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kt on GovHydroFrancis
   *
   * @param command AssignKtToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignKt(AssignKtToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Kt on GovHydroFrancis
   *
   * @param command UnAssignKtFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignKt(UnAssignKtFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kt on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qc0 on GovHydroFrancis
   *
   * @param command AssignQc0ToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignQc0(AssignQc0ToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Qc0 on GovHydroFrancis
   *
   * @param command UnAssignQc0FromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignQc0(UnAssignQc0FromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qc0 on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qn on GovHydroFrancis
   *
   * @param command AssignQnToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignQn(AssignQnToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VolumeFlowRateBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getVolumeFlowRateId();
    VolumeFlowRate child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Qn on GovHydroFrancis
   *
   * @param command UnAssignQnFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignQn(UnAssignQnFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qn on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ta on GovHydroFrancis
   *
   * @param command AssignTaToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignTa(AssignTaToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Ta on GovHydroFrancis
   *
   * @param command UnAssignTaFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignTa(UnAssignTaFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ta on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Td on GovHydroFrancis
   *
   * @param command AssignTdToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignTd(AssignTdToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Td on GovHydroFrancis
   *
   * @param command UnAssignTdFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignTd(UnAssignTdFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Td on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ts on GovHydroFrancis
   *
   * @param command AssignTsToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignTs(AssignTsToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Ts on GovHydroFrancis
   *
   * @param command UnAssignTsFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignTs(UnAssignTsFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ts on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twnc on GovHydroFrancis
   *
   * @param command AssignTwncToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignTwnc(AssignTwncToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Twnc on GovHydroFrancis
   *
   * @param command UnAssignTwncFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignTwnc(UnAssignTwncFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twnc on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twng on GovHydroFrancis
   *
   * @param command AssignTwngToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignTwng(AssignTwngToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Twng on GovHydroFrancis
   *
   * @param command UnAssignTwngFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignTwng(UnAssignTwngFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twng on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tx on GovHydroFrancis
   *
   * @param command AssignTxToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignTx(AssignTxToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Tx on GovHydroFrancis
   *
   * @param command UnAssignTxFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignTx(UnAssignTxFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tx on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Va on GovHydroFrancis
   *
   * @param command AssignVaToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignVa(AssignVaToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Va on GovHydroFrancis
   *
   * @param command UnAssignVaFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignVa(UnAssignVaFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Va on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Valvmax on GovHydroFrancis
   *
   * @param command AssignValvmaxToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignValvmax(AssignValvmaxToGovHydroFrancisCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Valvmax on GovHydroFrancis
   *
   * @param command UnAssignValvmaxFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignValvmax(UnAssignValvmaxFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Valvmax on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Valvmin on GovHydroFrancis
   *
   * @param command AssignValvminToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignValvmin(AssignValvminToGovHydroFrancisCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Valvmin on GovHydroFrancis
   *
   * @param command UnAssignValvminFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignValvmin(UnAssignValvminFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Valvmin on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vc on GovHydroFrancis
   *
   * @param command AssignVcToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignVc(AssignVcToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Vc on GovHydroFrancis
   *
   * @param command UnAssignVcFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignVc(UnAssignVcFromGovHydroFrancisCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vc on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign WaterTunnelSurgeChamberSimulation on GovHydroFrancis
   *
   * @param command AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignWaterTunnelSurgeChamberSimulation(
      AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign WaterTunnelSurgeChamberSimulation on GovHydroFrancis
   *
   * @param command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignWaterTunnelSurgeChamberSimulation(
      UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WaterTunnelSurgeChamberSimulation on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Zsfc on GovHydroFrancis
   *
   * @param command AssignZsfcToGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void assignZsfc(AssignZsfcToGovHydroFrancisCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGovHydroFrancisId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    GovHydroFrancisBusinessDelegate parentDelegate =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

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
   * unAssign Zsfc on GovHydroFrancis
   *
   * @param command UnAssignZsfcFromGovHydroFrancisCommand
   * @exception ProcessingException
   */
  public void unAssignZsfc(UnAssignZsfcFromGovHydroFrancisCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GovHydroFrancisValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Zsfc on GovHydroFrancis";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GovHydroFrancis
   */
  private GovHydroFrancis load(UUID id) throws ProcessingException {
    govHydroFrancis =
        GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance()
            .getGovHydroFrancis(new GovHydroFrancisFetchOneSummary(id));
    return govHydroFrancis;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GovHydroFrancis govHydroFrancis = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroFrancisBusinessDelegate.class.getName());
}
