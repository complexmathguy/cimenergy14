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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator.*;
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
 * UnderexcLimIEEE2 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of UnderexcLimIEEE2 related services in the case of a
 *       UnderexcLimIEEE2 business related service failing.
 *   <li>Exposes a simpler, uniform UnderexcLimIEEE2 interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill UnderexcLimIEEE2 business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class UnderexcLimIEEE2BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public UnderexcLimIEEE2BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * UnderexcLimIEEE2 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return UnderexcLimIEEE2BusinessDelegate
   */
  public static UnderexcLimIEEE2BusinessDelegate getUnderexcLimIEEE2Instance() {
    return (new UnderexcLimIEEE2BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createUnderexcLimIEEE2(CreateUnderexcLimIEEE2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getUnderexcLimIEEE2Id() == null) command.setUnderexcLimIEEE2Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateUnderexcLimIEEE2Command - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateUnderexcLimIEEE2Command of UnderexcLimIEEE2 is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create UnderexcLimIEEE2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateUnderexcLimIEEE2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateUnderexcLimIEEE2(UpdateUnderexcLimIEEE2Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateUnderexcLimIEEE2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save UnderexcLimIEEE2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteUnderexcLimIEEE2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteUnderexcLimIEEE2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteUnderexcLimIEEE2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete UnderexcLimIEEE2 using Id = " + command.getUnderexcLimIEEE2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the UnderexcLimIEEE2 via UnderexcLimIEEE2FetchOneSummary
   *
   * @param summary UnderexcLimIEEE2FetchOneSummary
   * @return UnderexcLimIEEE2FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public UnderexcLimIEEE2 getUnderexcLimIEEE2(UnderexcLimIEEE2FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("UnderexcLimIEEE2FetchOneSummary arg cannot be null");

    UnderexcLimIEEE2 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a UnderexcLimIEEE2
      // --------------------------------------
      CompletableFuture<UnderexcLimIEEE2> futureEntity =
          queryGateway.query(
              new FindUnderexcLimIEEE2Query(
                  new LoadUnderexcLimIEEE2Filter(summary.getUnderexcLimIEEE2Id())),
              ResponseTypes.instanceOf(UnderexcLimIEEE2.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate UnderexcLimIEEE2 with id " + summary.getUnderexcLimIEEE2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all UnderexcLimIEEE2s
   *
   * @return List<UnderexcLimIEEE2>
   * @exception ProcessingException Thrown if any problems
   */
  public List<UnderexcLimIEEE2> getAllUnderexcLimIEEE2() throws ProcessingException {
    List<UnderexcLimIEEE2> list = null;

    try {
      CompletableFuture<List<UnderexcLimIEEE2>> futureList =
          queryGateway.query(
              new FindAllUnderexcLimIEEE2Query(),
              ResponseTypes.multipleInstancesOf(UnderexcLimIEEE2.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign K1 on UnderexcLimIEEE2
   *
   * @param command AssignK1ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignK1(AssignK1ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign K1 on UnderexcLimIEEE2
   *
   * @param command UnAssignK1FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignK1(UnAssignK1FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K1 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign K2 on UnderexcLimIEEE2
   *
   * @param command AssignK2ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignK2(AssignK2ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign K2 on UnderexcLimIEEE2
   *
   * @param command UnAssignK2FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignK2(UnAssignK2FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K2 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kfb on UnderexcLimIEEE2
   *
   * @param command AssignKfbToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignKfb(AssignKfbToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Kfb on UnderexcLimIEEE2
   *
   * @param command UnAssignKfbFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignKfb(UnAssignKfbFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kfb on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kuf on UnderexcLimIEEE2
   *
   * @param command AssignKufToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignKuf(AssignKufToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Kuf on UnderexcLimIEEE2
   *
   * @param command UnAssignKufFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignKuf(UnAssignKufFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kuf on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kui on UnderexcLimIEEE2
   *
   * @param command AssignKuiToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignKui(AssignKuiToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Kui on UnderexcLimIEEE2
   *
   * @param command UnAssignKuiFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignKui(UnAssignKuiFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kui on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kul on UnderexcLimIEEE2
   *
   * @param command AssignKulToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignKul(AssignKulToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Kul on UnderexcLimIEEE2
   *
   * @param command UnAssignKulFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignKul(UnAssignKulFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kul on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P0 on UnderexcLimIEEE2
   *
   * @param command AssignP0ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP0(AssignP0ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P0 on UnderexcLimIEEE2
   *
   * @param command UnAssignP0FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP0(UnAssignP0FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P0 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P1 on UnderexcLimIEEE2
   *
   * @param command AssignP1ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP1(AssignP1ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P1 on UnderexcLimIEEE2
   *
   * @param command UnAssignP1FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP1(UnAssignP1FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P1 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P10 on UnderexcLimIEEE2
   *
   * @param command AssignP10ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP10(AssignP10ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P10 on UnderexcLimIEEE2
   *
   * @param command UnAssignP10FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP10(UnAssignP10FromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P10 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P2 on UnderexcLimIEEE2
   *
   * @param command AssignP2ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP2(AssignP2ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P2 on UnderexcLimIEEE2
   *
   * @param command UnAssignP2FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP2(UnAssignP2FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P2 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P3 on UnderexcLimIEEE2
   *
   * @param command AssignP3ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP3(AssignP3ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P3 on UnderexcLimIEEE2
   *
   * @param command UnAssignP3FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP3(UnAssignP3FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P3 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P4 on UnderexcLimIEEE2
   *
   * @param command AssignP4ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP4(AssignP4ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P4 on UnderexcLimIEEE2
   *
   * @param command UnAssignP4FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP4(UnAssignP4FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P4 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P5 on UnderexcLimIEEE2
   *
   * @param command AssignP5ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP5(AssignP5ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P5 on UnderexcLimIEEE2
   *
   * @param command UnAssignP5FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP5(UnAssignP5FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P5 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P6 on UnderexcLimIEEE2
   *
   * @param command AssignP6ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP6(AssignP6ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P6 on UnderexcLimIEEE2
   *
   * @param command UnAssignP6FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP6(UnAssignP6FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P6 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P7 on UnderexcLimIEEE2
   *
   * @param command AssignP7ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP7(AssignP7ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P7 on UnderexcLimIEEE2
   *
   * @param command UnAssignP7FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP7(UnAssignP7FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P7 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P8 on UnderexcLimIEEE2
   *
   * @param command AssignP8ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP8(AssignP8ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P8 on UnderexcLimIEEE2
   *
   * @param command UnAssignP8FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP8(UnAssignP8FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P8 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P9 on UnderexcLimIEEE2
   *
   * @param command AssignP9ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignP9(AssignP9ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign P9 on UnderexcLimIEEE2
   *
   * @param command UnAssignP9FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignP9(UnAssignP9FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P9 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q0 on UnderexcLimIEEE2
   *
   * @param command AssignQ0ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ0(AssignQ0ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q0 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ0FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ0(UnAssignQ0FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q0 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q1 on UnderexcLimIEEE2
   *
   * @param command AssignQ1ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ1(AssignQ1ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q1 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ1FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ1(UnAssignQ1FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q1 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q10 on UnderexcLimIEEE2
   *
   * @param command AssignQ10ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ10(AssignQ10ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q10 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ10FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ10(UnAssignQ10FromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q10 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q2 on UnderexcLimIEEE2
   *
   * @param command AssignQ2ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ2(AssignQ2ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q2 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ2FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ2(UnAssignQ2FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q2 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q3 on UnderexcLimIEEE2
   *
   * @param command AssignQ3ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ3(AssignQ3ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q3 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ3FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ3(UnAssignQ3FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q3 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q4 on UnderexcLimIEEE2
   *
   * @param command AssignQ4ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ4(AssignQ4ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q4 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ4FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ4(UnAssignQ4FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q4 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q5 on UnderexcLimIEEE2
   *
   * @param command AssignQ5ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ5(AssignQ5ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q5 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ5FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ5(UnAssignQ5FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q5 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q6 on UnderexcLimIEEE2
   *
   * @param command AssignQ6ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ6(AssignQ6ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q6 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ6FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ6(UnAssignQ6FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q6 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q7 on UnderexcLimIEEE2
   *
   * @param command AssignQ7ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ7(AssignQ7ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q7 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ7FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ7(UnAssignQ7FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q7 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q8 on UnderexcLimIEEE2
   *
   * @param command AssignQ8ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ8(AssignQ8ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q8 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ8FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ8(UnAssignQ8FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q8 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q9 on UnderexcLimIEEE2
   *
   * @param command AssignQ9ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignQ9(AssignQ9ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Q9 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ9FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignQ9(UnAssignQ9FromUnderexcLimIEEE2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q9 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu1 on UnderexcLimIEEE2
   *
   * @param command AssignTu1ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTu1(AssignTu1ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tu1 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu1FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTu1(UnAssignTu1FromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu1 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu2 on UnderexcLimIEEE2
   *
   * @param command AssignTu2ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTu2(AssignTu2ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tu2 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu2FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTu2(UnAssignTu2FromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu2 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu3 on UnderexcLimIEEE2
   *
   * @param command AssignTu3ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTu3(AssignTu3ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tu3 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu3FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTu3(UnAssignTu3FromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu3 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu4 on UnderexcLimIEEE2
   *
   * @param command AssignTu4ToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTu4(AssignTu4ToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tu4 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu4FromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTu4(UnAssignTu4FromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu4 on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tul on UnderexcLimIEEE2
   *
   * @param command AssignTulToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTul(AssignTulToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tul on UnderexcLimIEEE2
   *
   * @param command UnAssignTulFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTul(UnAssignTulFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tul on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tup on UnderexcLimIEEE2
   *
   * @param command AssignTupToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTup(AssignTupToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tup on UnderexcLimIEEE2
   *
   * @param command UnAssignTupFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTup(UnAssignTupFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tup on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tuq on UnderexcLimIEEE2
   *
   * @param command AssignTuqToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTuq(AssignTuqToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tuq on UnderexcLimIEEE2
   *
   * @param command UnAssignTuqFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTuq(UnAssignTuqFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tuq on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tuv on UnderexcLimIEEE2
   *
   * @param command AssignTuvToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignTuv(AssignTuvToUnderexcLimIEEE2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Tuv on UnderexcLimIEEE2
   *
   * @param command UnAssignTuvFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignTuv(UnAssignTuvFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tuv on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vuimax on UnderexcLimIEEE2
   *
   * @param command AssignVuimaxToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignVuimax(AssignVuimaxToUnderexcLimIEEE2Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Vuimax on UnderexcLimIEEE2
   *
   * @param command UnAssignVuimaxFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignVuimax(UnAssignVuimaxFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vuimax on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vuimin on UnderexcLimIEEE2
   *
   * @param command AssignVuiminToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignVuimin(AssignVuiminToUnderexcLimIEEE2Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Vuimin on UnderexcLimIEEE2
   *
   * @param command UnAssignVuiminFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignVuimin(UnAssignVuiminFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vuimin on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vulmax on UnderexcLimIEEE2
   *
   * @param command AssignVulmaxToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignVulmax(AssignVulmaxToUnderexcLimIEEE2Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Vulmax on UnderexcLimIEEE2
   *
   * @param command UnAssignVulmaxFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignVulmax(UnAssignVulmaxFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vulmax on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vulmin on UnderexcLimIEEE2
   *
   * @param command AssignVulminToUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void assignVulmin(AssignVulminToUnderexcLimIEEE2Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE2BusinessDelegate parentDelegate =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

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
   * unAssign Vulmin on UnderexcLimIEEE2
   *
   * @param command UnAssignVulminFromUnderexcLimIEEE2Command
   * @exception ProcessingException
   */
  public void unAssignVulmin(UnAssignVulminFromUnderexcLimIEEE2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vulmin on UnderexcLimIEEE2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return UnderexcLimIEEE2
   */
  private UnderexcLimIEEE2 load(UUID id) throws ProcessingException {
    underexcLimIEEE2 =
        UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance()
            .getUnderexcLimIEEE2(new UnderexcLimIEEE2FetchOneSummary(id));
    return underexcLimIEEE2;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private UnderexcLimIEEE2 underexcLimIEEE2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimIEEE2BusinessDelegate.class.getName());
}
