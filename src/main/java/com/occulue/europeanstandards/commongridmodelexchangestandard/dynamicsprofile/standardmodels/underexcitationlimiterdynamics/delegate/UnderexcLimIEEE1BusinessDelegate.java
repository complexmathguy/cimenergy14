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
 * UnderexcLimIEEE1 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of UnderexcLimIEEE1 related services in the case of a
 *       UnderexcLimIEEE1 business related service failing.
 *   <li>Exposes a simpler, uniform UnderexcLimIEEE1 interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill UnderexcLimIEEE1 business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class UnderexcLimIEEE1BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public UnderexcLimIEEE1BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * UnderexcLimIEEE1 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return UnderexcLimIEEE1BusinessDelegate
   */
  public static UnderexcLimIEEE1BusinessDelegate getUnderexcLimIEEE1Instance() {
    return (new UnderexcLimIEEE1BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createUnderexcLimIEEE1(CreateUnderexcLimIEEE1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getUnderexcLimIEEE1Id() == null) command.setUnderexcLimIEEE1Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateUnderexcLimIEEE1Command - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateUnderexcLimIEEE1Command of UnderexcLimIEEE1 is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create UnderexcLimIEEE1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateUnderexcLimIEEE1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateUnderexcLimIEEE1(UpdateUnderexcLimIEEE1Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateUnderexcLimIEEE1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save UnderexcLimIEEE1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteUnderexcLimIEEE1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteUnderexcLimIEEE1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteUnderexcLimIEEE1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete UnderexcLimIEEE1 using Id = " + command.getUnderexcLimIEEE1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the UnderexcLimIEEE1 via UnderexcLimIEEE1FetchOneSummary
   *
   * @param summary UnderexcLimIEEE1FetchOneSummary
   * @return UnderexcLimIEEE1FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public UnderexcLimIEEE1 getUnderexcLimIEEE1(UnderexcLimIEEE1FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("UnderexcLimIEEE1FetchOneSummary arg cannot be null");

    UnderexcLimIEEE1 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a UnderexcLimIEEE1
      // --------------------------------------
      CompletableFuture<UnderexcLimIEEE1> futureEntity =
          queryGateway.query(
              new FindUnderexcLimIEEE1Query(
                  new LoadUnderexcLimIEEE1Filter(summary.getUnderexcLimIEEE1Id())),
              ResponseTypes.instanceOf(UnderexcLimIEEE1.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate UnderexcLimIEEE1 with id " + summary.getUnderexcLimIEEE1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all UnderexcLimIEEE1s
   *
   * @return List<UnderexcLimIEEE1>
   * @exception ProcessingException Thrown if any problems
   */
  public List<UnderexcLimIEEE1> getAllUnderexcLimIEEE1() throws ProcessingException {
    List<UnderexcLimIEEE1> list = null;

    try {
      CompletableFuture<List<UnderexcLimIEEE1>> futureList =
          queryGateway.query(
              new FindAllUnderexcLimIEEE1Query(),
              ResponseTypes.multipleInstancesOf(UnderexcLimIEEE1.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kuc on UnderexcLimIEEE1
   *
   * @param command AssignKucToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignKuc(AssignKucToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Kuc on UnderexcLimIEEE1
   *
   * @param command UnAssignKucFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignKuc(UnAssignKucFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kuc on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kuf on UnderexcLimIEEE1
   *
   * @param command AssignKufToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignKuf(AssignKufToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Kuf on UnderexcLimIEEE1
   *
   * @param command UnAssignKufFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignKuf(UnAssignKufFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kuf on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kui on UnderexcLimIEEE1
   *
   * @param command AssignKuiToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignKui(AssignKuiToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Kui on UnderexcLimIEEE1
   *
   * @param command UnAssignKuiFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignKui(UnAssignKuiFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kui on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kul on UnderexcLimIEEE1
   *
   * @param command AssignKulToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignKul(AssignKulToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Kul on UnderexcLimIEEE1
   *
   * @param command UnAssignKulFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignKul(UnAssignKulFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kul on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kur on UnderexcLimIEEE1
   *
   * @param command AssignKurToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignKur(AssignKurToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Kur on UnderexcLimIEEE1
   *
   * @param command UnAssignKurFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignKur(UnAssignKurFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kur on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu1 on UnderexcLimIEEE1
   *
   * @param command AssignTu1ToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignTu1(AssignTu1ToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Tu1 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu1FromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignTu1(UnAssignTu1FromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu1 on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu2 on UnderexcLimIEEE1
   *
   * @param command AssignTu2ToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignTu2(AssignTu2ToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Tu2 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu2FromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignTu2(UnAssignTu2FromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu2 on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu3 on UnderexcLimIEEE1
   *
   * @param command AssignTu3ToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignTu3(AssignTu3ToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Tu3 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu3FromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignTu3(UnAssignTu3FromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu3 on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tu4 on UnderexcLimIEEE1
   *
   * @param command AssignTu4ToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignTu4(AssignTu4ToUnderexcLimIEEE1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Tu4 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu4FromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignTu4(UnAssignTu4FromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tu4 on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vucmax on UnderexcLimIEEE1
   *
   * @param command AssignVucmaxToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignVucmax(AssignVucmaxToUnderexcLimIEEE1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Vucmax on UnderexcLimIEEE1
   *
   * @param command UnAssignVucmaxFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignVucmax(UnAssignVucmaxFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vucmax on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vuimax on UnderexcLimIEEE1
   *
   * @param command AssignVuimaxToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignVuimax(AssignVuimaxToUnderexcLimIEEE1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Vuimax on UnderexcLimIEEE1
   *
   * @param command UnAssignVuimaxFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignVuimax(UnAssignVuimaxFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vuimax on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vuimin on UnderexcLimIEEE1
   *
   * @param command AssignVuiminToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignVuimin(AssignVuiminToUnderexcLimIEEE1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Vuimin on UnderexcLimIEEE1
   *
   * @param command UnAssignVuiminFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignVuimin(UnAssignVuiminFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vuimin on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vulmax on UnderexcLimIEEE1
   *
   * @param command AssignVulmaxToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignVulmax(AssignVulmaxToUnderexcLimIEEE1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Vulmax on UnderexcLimIEEE1
   *
   * @param command UnAssignVulmaxFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignVulmax(UnAssignVulmaxFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vulmax on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vulmin on UnderexcLimIEEE1
   *
   * @param command AssignVulminToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignVulmin(AssignVulminToUnderexcLimIEEE1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Vulmin on UnderexcLimIEEE1
   *
   * @param command UnAssignVulminFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignVulmin(UnAssignVulminFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vulmin on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vurmax on UnderexcLimIEEE1
   *
   * @param command AssignVurmaxToUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void assignVurmax(AssignVurmaxToUnderexcLimIEEE1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLimIEEE1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLimIEEE1BusinessDelegate parentDelegate =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

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
   * unAssign Vurmax on UnderexcLimIEEE1
   *
   * @param command UnAssignVurmaxFromUnderexcLimIEEE1Command
   * @exception ProcessingException
   */
  public void unAssignVurmax(UnAssignVurmaxFromUnderexcLimIEEE1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLimIEEE1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vurmax on UnderexcLimIEEE1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return UnderexcLimIEEE1
   */
  private UnderexcLimIEEE1 load(UUID id) throws ProcessingException {
    underexcLimIEEE1 =
        UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance()
            .getUnderexcLimIEEE1(new UnderexcLimIEEE1FetchOneSummary(id));
    return underexcLimIEEE1;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private UnderexcLimIEEE1 underexcLimIEEE1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimIEEE1BusinessDelegate.class.getName());
}
