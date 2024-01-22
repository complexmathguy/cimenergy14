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
package com.occulue.europeanstandards.extension.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.validator.*;
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
 * BoundaryExtensions business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of BoundaryExtensions related services in the case of a
 *       BoundaryExtensions business related service failing.
 *   <li>Exposes a simpler, uniform BoundaryExtensions interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill BoundaryExtensions
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class BoundaryExtensionsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public BoundaryExtensionsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * BoundaryExtensions Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return BoundaryExtensionsBusinessDelegate
   */
  public static BoundaryExtensionsBusinessDelegate getBoundaryExtensionsInstance() {
    return (new BoundaryExtensionsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createBoundaryExtensions(CreateBoundaryExtensionsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getBoundaryExtensionsId() == null)
        command.setBoundaryExtensionsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateBoundaryExtensionsCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateBoundaryExtensionsCommand of BoundaryExtensions is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create BoundaryExtensions - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateBoundaryExtensionsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateBoundaryExtensions(UpdateBoundaryExtensionsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateBoundaryExtensionsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save BoundaryExtensions - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteBoundaryExtensionsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteBoundaryExtensionsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteBoundaryExtensionsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete BoundaryExtensions using Id = " + command.getBoundaryExtensionsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the BoundaryExtensions via BoundaryExtensionsFetchOneSummary
   *
   * @param summary BoundaryExtensionsFetchOneSummary
   * @return BoundaryExtensionsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public BoundaryExtensions getBoundaryExtensions(BoundaryExtensionsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("BoundaryExtensionsFetchOneSummary arg cannot be null");

    BoundaryExtensions entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a BoundaryExtensions
      // --------------------------------------
      CompletableFuture<BoundaryExtensions> futureEntity =
          queryGateway.query(
              new FindBoundaryExtensionsQuery(
                  new LoadBoundaryExtensionsFilter(summary.getBoundaryExtensionsId())),
              ResponseTypes.instanceOf(BoundaryExtensions.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate BoundaryExtensions with id " + summary.getBoundaryExtensionsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all BoundaryExtensionss
   *
   * @return List<BoundaryExtensions>
   * @exception ProcessingException Thrown if any problems
   */
  public List<BoundaryExtensions> getAllBoundaryExtensions() throws ProcessingException {
    List<BoundaryExtensions> list = null;

    try {
      CompletableFuture<List<BoundaryExtensions>> futureList =
          queryGateway.query(
              new FindAllBoundaryExtensionsQuery(),
              ResponseTypes.multipleInstancesOf(BoundaryExtensions.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all BoundaryExtensions";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BoundaryPoint on BoundaryExtensions
   *
   * @param command AssignBoundaryPointToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignBoundaryPoint(AssignBoundaryPointToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

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
   * unAssign BoundaryPoint on BoundaryExtensions
   *
   * @param command UnAssignBoundaryPointFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignBoundaryPoint(UnAssignBoundaryPointFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BoundaryPoint on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndIsoCode on BoundaryExtensions
   *
   * @param command AssignFromEndIsoCodeToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignFromEndIsoCode(AssignFromEndIsoCodeToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndIsoCode on BoundaryExtensions
   *
   * @param command UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndIsoCode(UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndIsoCode on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndName on BoundaryExtensions
   *
   * @param command AssignFromEndNameToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignFromEndName(AssignFromEndNameToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndName on BoundaryExtensions
   *
   * @param command UnAssignFromEndNameFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndName(UnAssignFromEndNameFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndName on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndNameTso on BoundaryExtensions
   *
   * @param command AssignFromEndNameTsoToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignFromEndNameTso(AssignFromEndNameTsoToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndNameTso on BoundaryExtensions
   *
   * @param command UnAssignFromEndNameTsoFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndNameTso(UnAssignFromEndNameTsoFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndNameTso on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndIsoCode on BoundaryExtensions
   *
   * @param command AssignToEndIsoCodeToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignToEndIsoCode(AssignToEndIsoCodeToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndIsoCode on BoundaryExtensions
   *
   * @param command UnAssignToEndIsoCodeFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignToEndIsoCode(UnAssignToEndIsoCodeFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndIsoCode on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndName on BoundaryExtensions
   *
   * @param command AssignToEndNameToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignToEndName(AssignToEndNameToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndName on BoundaryExtensions
   *
   * @param command UnAssignToEndNameFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignToEndName(UnAssignToEndNameFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndName on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndNameTso on BoundaryExtensions
   *
   * @param command AssignToEndNameTsoToBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void assignToEndNameTso(AssignToEndNameTsoToBoundaryExtensionsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBoundaryExtensionsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    BoundaryExtensionsBusinessDelegate parentDelegate =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndNameTso on BoundaryExtensions
   *
   * @param command UnAssignToEndNameTsoFromBoundaryExtensionsCommand
   * @exception ProcessingException
   */
  public void unAssignToEndNameTso(UnAssignToEndNameTsoFromBoundaryExtensionsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BoundaryExtensionsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndNameTso on BoundaryExtensions";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return BoundaryExtensions
   */
  private BoundaryExtensions load(UUID id) throws ProcessingException {
    boundaryExtensions =
        BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
            .getBoundaryExtensions(new BoundaryExtensionsFetchOneSummary(id));
    return boundaryExtensions;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private BoundaryExtensions boundaryExtensions = null;
  private static final Logger LOGGER =
      Logger.getLogger(BoundaryExtensionsBusinessDelegate.class.getName());
}
