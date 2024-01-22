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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.validator.*;
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
 * DiscExcContIEEEDEC1A business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DiscExcContIEEEDEC1A related services in the case of a
 *       DiscExcContIEEEDEC1A business related service failing.
 *   <li>Exposes a simpler, uniform DiscExcContIEEEDEC1A interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DiscExcContIEEEDEC1A
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DiscExcContIEEEDEC1ABusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DiscExcContIEEEDEC1ABusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DiscExcContIEEEDEC1A Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DiscExcContIEEEDEC1ABusinessDelegate
   */
  public static DiscExcContIEEEDEC1ABusinessDelegate getDiscExcContIEEEDEC1AInstance() {
    return (new DiscExcContIEEEDEC1ABusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDiscExcContIEEEDEC1A(
      CreateDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDiscExcContIEEEDEC1AId() == null)
        command.setDiscExcContIEEEDEC1AId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDiscExcContIEEEDEC1ACommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDiscExcContIEEEDEC1ACommand of DiscExcContIEEEDEC1A is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DiscExcContIEEEDEC1A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDiscExcContIEEEDEC1ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDiscExcContIEEEDEC1A(
      UpdateDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDiscExcContIEEEDEC1ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DiscExcContIEEEDEC1A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDiscExcContIEEEDEC1ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDiscExcContIEEEDEC1ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DiscExcContIEEEDEC1A using Id = " + command.getDiscExcContIEEEDEC1AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DiscExcContIEEEDEC1A via DiscExcContIEEEDEC1AFetchOneSummary
   *
   * @param summary DiscExcContIEEEDEC1AFetchOneSummary
   * @return DiscExcContIEEEDEC1AFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DiscExcContIEEEDEC1A getDiscExcContIEEEDEC1A(DiscExcContIEEEDEC1AFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DiscExcContIEEEDEC1AFetchOneSummary arg cannot be null");

    DiscExcContIEEEDEC1A entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DiscExcContIEEEDEC1A
      // --------------------------------------
      CompletableFuture<DiscExcContIEEEDEC1A> futureEntity =
          queryGateway.query(
              new FindDiscExcContIEEEDEC1AQuery(
                  new LoadDiscExcContIEEEDEC1AFilter(summary.getDiscExcContIEEEDEC1AId())),
              ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DiscExcContIEEEDEC1A with id " + summary.getDiscExcContIEEEDEC1AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DiscExcContIEEEDEC1As
   *
   * @return List<DiscExcContIEEEDEC1A>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DiscExcContIEEEDEC1A> getAllDiscExcContIEEEDEC1A() throws ProcessingException {
    List<DiscExcContIEEEDEC1A> list = null;

    try {
      CompletableFuture<List<DiscExcContIEEEDEC1A>> futureList =
          queryGateway.query(
              new FindAllDiscExcContIEEEDEC1AQuery(),
              ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC1A.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Esc on DiscExcContIEEEDEC1A
   *
   * @param command AssignEscToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignEsc(AssignEscToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Esc on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignEscFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignEsc(UnAssignEscFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Esc on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kan on DiscExcContIEEEDEC1A
   *
   * @param command AssignKanToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignKan(AssignKanToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Kan on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignKanFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignKan(UnAssignKanFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kan on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ketl on DiscExcContIEEEDEC1A
   *
   * @param command AssignKetlToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignKetl(AssignKetlToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Ketl on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignKetlFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignKetl(UnAssignKetlFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ketl on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tan on DiscExcContIEEEDEC1A
   *
   * @param command AssignTanToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignTan(AssignTanToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Tan on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTanFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignTan(UnAssignTanFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tan on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Td on DiscExcContIEEEDEC1A
   *
   * @param command AssignTdToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignTd(AssignTdToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Td on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTdFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignTd(UnAssignTdFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Td on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tl1 on DiscExcContIEEEDEC1A
   *
   * @param command AssignTl1ToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignTl1(AssignTl1ToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Tl1 on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTl1FromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignTl1(UnAssignTl1FromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tl1 on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tl2 on DiscExcContIEEEDEC1A
   *
   * @param command AssignTl2ToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignTl2(AssignTl2ToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Tl2 on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTl2FromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignTl2(UnAssignTl2FromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tl2 on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw5 on DiscExcContIEEEDEC1A
   *
   * @param command AssignTw5ToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignTw5(AssignTw5ToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Tw5 on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTw5FromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignTw5(UnAssignTw5FromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw5 on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Value on DiscExcContIEEEDEC1A
   *
   * @param command AssignValueToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Value on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignValueFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vanmax on DiscExcContIEEEDEC1A
   *
   * @param command AssignVanmaxToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVanmax(AssignVanmaxToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vanmax on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVanmax(UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vanmax on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vomax on DiscExcContIEEEDEC1A
   *
   * @param command AssignVomaxToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVomax(AssignVomaxToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vomax on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVomaxFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVomax(UnAssignVomaxFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vomax on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vomin on DiscExcContIEEEDEC1A
   *
   * @param command AssignVominToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVomin(AssignVominToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vomin on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVominFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVomin(UnAssignVominFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vomin on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vsmax on DiscExcContIEEEDEC1A
   *
   * @param command AssignVsmaxToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVsmax(AssignVsmaxToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vsmax on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVsmax(UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vsmax on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vsmin on DiscExcContIEEEDEC1A
   *
   * @param command AssignVsminToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVsmin(AssignVsminToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vsmin on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVsminFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVsmin(UnAssignVsminFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vsmin on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vtc on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtcToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVtc(AssignVtcToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vtc on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtcFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVtc(UnAssignVtcFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vtc on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vtlmt on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtlmtToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVtlmt(AssignVtlmtToDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vtlmt on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVtlmt(UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vtlmt on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vtm on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtmToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVtm(AssignVtmToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vtm on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtmFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVtm(UnAssignVtmFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vtm on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vtn on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtnToDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void assignVtn(AssignVtnToDiscExcContIEEEDEC1ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC1AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC1ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

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
   * unAssign Vtn on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtnFromDiscExcContIEEEDEC1ACommand
   * @exception ProcessingException
   */
  public void unAssignVtn(UnAssignVtnFromDiscExcContIEEEDEC1ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC1AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vtn on DiscExcContIEEEDEC1A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DiscExcContIEEEDEC1A
   */
  private DiscExcContIEEEDEC1A load(UUID id) throws ProcessingException {
    discExcContIEEEDEC1A =
        DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance()
            .getDiscExcContIEEEDEC1A(new DiscExcContIEEEDEC1AFetchOneSummary(id));
    return discExcContIEEEDEC1A;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DiscExcContIEEEDEC1A discExcContIEEEDEC1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC1ABusinessDelegate.class.getName());
}
