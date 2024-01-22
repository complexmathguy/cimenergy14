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
 * DiscExcContIEEEDEC2A business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DiscExcContIEEEDEC2A related services in the case of a
 *       DiscExcContIEEEDEC2A business related service failing.
 *   <li>Exposes a simpler, uniform DiscExcContIEEEDEC2A interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DiscExcContIEEEDEC2A
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DiscExcContIEEEDEC2ABusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DiscExcContIEEEDEC2ABusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DiscExcContIEEEDEC2A Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DiscExcContIEEEDEC2ABusinessDelegate
   */
  public static DiscExcContIEEEDEC2ABusinessDelegate getDiscExcContIEEEDEC2AInstance() {
    return (new DiscExcContIEEEDEC2ABusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDiscExcContIEEEDEC2A(
      CreateDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDiscExcContIEEEDEC2AId() == null)
        command.setDiscExcContIEEEDEC2AId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDiscExcContIEEEDEC2ACommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDiscExcContIEEEDEC2ACommand of DiscExcContIEEEDEC2A is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DiscExcContIEEEDEC2A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDiscExcContIEEEDEC2ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDiscExcContIEEEDEC2A(
      UpdateDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDiscExcContIEEEDEC2ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DiscExcContIEEEDEC2A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDiscExcContIEEEDEC2ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDiscExcContIEEEDEC2ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DiscExcContIEEEDEC2A using Id = " + command.getDiscExcContIEEEDEC2AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DiscExcContIEEEDEC2A via DiscExcContIEEEDEC2AFetchOneSummary
   *
   * @param summary DiscExcContIEEEDEC2AFetchOneSummary
   * @return DiscExcContIEEEDEC2AFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DiscExcContIEEEDEC2A getDiscExcContIEEEDEC2A(DiscExcContIEEEDEC2AFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DiscExcContIEEEDEC2AFetchOneSummary arg cannot be null");

    DiscExcContIEEEDEC2A entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DiscExcContIEEEDEC2A
      // --------------------------------------
      CompletableFuture<DiscExcContIEEEDEC2A> futureEntity =
          queryGateway.query(
              new FindDiscExcContIEEEDEC2AQuery(
                  new LoadDiscExcContIEEEDEC2AFilter(summary.getDiscExcContIEEEDEC2AId())),
              ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DiscExcContIEEEDEC2A with id " + summary.getDiscExcContIEEEDEC2AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DiscExcContIEEEDEC2As
   *
   * @return List<DiscExcContIEEEDEC2A>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DiscExcContIEEEDEC2A> getAllDiscExcContIEEEDEC2A() throws ProcessingException {
    List<DiscExcContIEEEDEC2A> list = null;

    try {
      CompletableFuture<List<DiscExcContIEEEDEC2A>> futureList =
          queryGateway.query(
              new FindAllDiscExcContIEEEDEC2AQuery(),
              ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC2A.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DiscExcContIEEEDEC2A";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Td1 on DiscExcContIEEEDEC2A
   *
   * @param command AssignTd1ToDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void assignTd1(AssignTd1ToDiscExcContIEEEDEC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC2ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

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
   * unAssign Td1 on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignTd1FromDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTd1(UnAssignTd1FromDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Td1 on DiscExcContIEEEDEC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Td2 on DiscExcContIEEEDEC2A
   *
   * @param command AssignTd2ToDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void assignTd2(AssignTd2ToDiscExcContIEEEDEC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    DiscExcContIEEEDEC2ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

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
   * unAssign Td2 on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignTd2FromDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTd2(UnAssignTd2FromDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Td2 on DiscExcContIEEEDEC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vdmax on DiscExcContIEEEDEC2A
   *
   * @param command AssignVdmaxToDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void assignVdmax(AssignVdmaxToDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC2ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

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
   * unAssign Vdmax on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVdmax(UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vdmax on DiscExcContIEEEDEC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vdmin on DiscExcContIEEEDEC2A
   *
   * @param command AssignVdminToDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void assignVdmin(AssignVdminToDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC2ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

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
   * unAssign Vdmin on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVdminFromDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVdmin(UnAssignVdminFromDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vdmin on DiscExcContIEEEDEC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vk on DiscExcContIEEEDEC2A
   *
   * @param command AssignVkToDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void assignVk(AssignVkToDiscExcContIEEEDEC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscExcContIEEEDEC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    DiscExcContIEEEDEC2ABusinessDelegate parentDelegate =
        DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

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
   * unAssign Vk on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVkFromDiscExcContIEEEDEC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVk(UnAssignVkFromDiscExcContIEEEDEC2ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscExcContIEEEDEC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vk on DiscExcContIEEEDEC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DiscExcContIEEEDEC2A
   */
  private DiscExcContIEEEDEC2A load(UUID id) throws ProcessingException {
    discExcContIEEEDEC2A =
        DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance()
            .getDiscExcContIEEEDEC2A(new DiscExcContIEEEDEC2AFetchOneSummary(id));
    return discExcContIEEEDEC2A;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DiscExcContIEEEDEC2A discExcContIEEEDEC2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC2ABusinessDelegate.class.getName());
}
